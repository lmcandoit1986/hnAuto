package com.hnrmb.Utils;

import android.app.Instrumentation;
import android.app.Notification;
import android.app.UiAutomation;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.accessibility.AccessibilityEvent;

import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import com.hnrmb.Config.Config;

import java.io.IOException;

/**
 * Created by liming on 2020/3/24.
 */

public class AppLaunch {

    public AppLaunch(){
    }

    public Boolean startApp(UiDevice MDevice, String PackageName, String StartActivityName){
        LogInfo.i(String.format("Start App:%s",PackageName));
        /**
         * 优先使用
         */
        try {
            MDevice.executeShellCommand("am start "+PackageName+"/"+StartActivityName);
            Thread.sleep(6000);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (MDevice.getCurrentPackageName().equals(PackageName)){
            return true;
        }
        return false;



    }

    public void quitApp(UiDevice MDevice, String PackageName){
        try {
            MDevice.executeShellCommand("am force-stop "+PackageName);
            Thread.sleep(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void startIntent(Context context, UiDevice MDevice, String PackageName){
        LogInfo.i("执行 Intent 命令启动 App");
        final Intent intent = context.getPackageManager().getLaunchIntentForPackage(PackageName);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void initToastListener(Instrumentation instrumentation) {
        /**
         * 设置监听获取toast等信息
         */
        instrumentation.getUiAutomation().setOnAccessibilityEventListener(new UiAutomation.OnAccessibilityEventListener() {
            @Override
            public void onAccessibilityEvent(AccessibilityEvent event) {
                if (event.getEventType()!= AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED) {
                    return;
                }

                //获取消息来源
//                String sourcePackageName = (String) event.getPackageName();

                //获取事件具体信息
                Parcelable parcelable = event.getParcelableData();

                //如果不是下拉通知栏消息，则为其它通知信息，包括Toast
                if (!(parcelable instanceof Notification)) {
                    Config.ToastMMSG = (String) event.getText().get(0);
                }else{
                    LogInfo.i(event.getText().get(0).toString());
                    String smstext = event.getText().get(0).toString();
                    // 具体提取业务逻辑实现
//                    if(smstext.contains("中国平安: 尊敬的客户，您的验证码为")){
//                        ConfigGlobal.Code = smstext.split("：")[1].split("，")[0];
//                    }
                }
            }
        });
    }


    public String getCode(UiDevice MDevice){
        /**
         * 直接遍历通知栏获取内容
         */
        String res=null;
        MDevice.openNotification();
        UiObject tar = MDevice.findObject(new UiSelector().textContains("验证码"));
        tar.waitForExists(5000);
        try {
            res = tar.getText();
            LogInfo.i(res);
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }

        //…客户，您的验证码为：176710，有效期2分钟。买健康险，就上平安健康APP！【平安健康险】
        MDevice.pressBack();
        if(!res.equals(null)){
            return res.split("：")[1].split("，")[0];
        }
        return null;
    }

}
