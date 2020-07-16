package com.hnrmb.Utils;

import android.graphics.Path;
import android.os.Bundle;
import android.util.Pair;

import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.UiWatcher;

import com.hnrmb.Config.Config;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WatcherList {

    public static void allException(final Solo solo){
        final UiObjectNew UN = UiObjectNew.getInstance(solo);
        /**
        UiDevice uiDevice = solo.getMydevice();
        List<UiSelector> list = new ArrayList<>();
        list.add(Selector.resourceId("com.hnrmb.salary:id/linear_close"));
        list.add(Selector.resourceId("com.hnrmb.salary:id/iv_close"));
        list.add(Selector.resourceId("com.hnrmb.salary:id/permission_allow_button"));
        list.add(Selector.resourceId("com.hnrmb.salary:id/warn_cancel"));
        list.add(Selector.resourceId("android:id/button1").text("存储"));
        Stack<String> WatcherName = new Stack<String>();
        WatcherName.add("update");
        WatcherName.add("tv");
        WatcherName.add("permission");
        WatcherName.add("cancel");
        WatcherName.add("single");
        WatcherName.add("save");
        WatcherName.add("phone");
         **/
        /**
         * 要允许华能成长宝访问您设备上的照片、媒体内容和文件吗？始终允许 com.android.packageinstaller:id/permission_allow_button
         * com.hnrmb.salary:id/realtive_update com.hnrmb.salary:id/linear_close
         * 是否启用指纹解锁 com.hnrmb.salary:id/warn_cancel 取消
         * 您还可以在"设置－账户安全－指纹解锁"中开启指纹解锁 com.hnrmb.salary:id/btn_single_confirm 确定
         * com.hnrmb.salary:id/dialog_content_info
         * com.hnrmb.salary:id/iv_close
         */
        createUiWatcher(solo,UN,"permission",Selector.text("要允许华能成长宝访问您设备上的照片、媒体内容和文件吗？"),Selector.text("始终允许").resourceId("com.android.packageinstaller:id/permission_allow_button"));
        createUiWatcher(solo,UN,"update",Selector.resourceId("com.hnrmb.salary:id/realtive_update"),Selector.resourceId("com.hnrmb.salary:id/linear_close"));
        createUiWatcher(solo,UN,"Touch1",Selector.text("是否启用指纹解锁"),Selector.resourceId("com.hnrmb.salary:id/warn_cancel").text("取消"));
        createUiWatcher(solo,UN,"touch2",Selector.text("您还可以在\"我的－个人设置－账户安全－指纹解锁\"中开启指纹解锁"),Selector.resourceId("com.hnrmb.salary:id/btn_single_confirm").text("确定"));
        createUiWatcher(solo,UN,"tv",Selector.resourceId("com.hnrmb.salary:id/iv_close"),Selector.resourceId("com.hnrmb.salary:id/iv_close"));
        createUiWatcher(solo,UN,"road",Selector.resourceId("com.hnrmb.salary:id/iv_next"),Selector.resourceId("com.hnrmb.salary:id/iv_next"));
        if(!Config.ENV.equals("rel")){
            createUiWatcherIsAssert(solo,UN,"e1",Selector.textContains("服务").resourceId("com.hnrmb.salary:id/dialog_content_info"),Selector.resourceId("com.hnrmb.salary:id/btn_single_confirm"));
            createUiWatcherIsAssert(solo,UN,"e2",Selector.textContains("异常").resourceId("com.hnrmb.salary:id/dialog_content_info"),Selector.resourceId("com.hnrmb.salary:id/btn_single_confirm"));
            createUiWatcherIsAssert(solo,UN,"e3",Selector.textContains("错误").resourceId("com.hnrmb.salary:id/tv_content"),Selector.resourceId("com.hnrmb.salary:id/btn_single_confirm"));
            createUiWatcherIsAssert(solo,UN,"e5",Selector.textContains("服务").resourceId("com.hnrmb.salary:id/tv_content"),Selector.resourceId("com.hnrmb.salary:id/btn_single_confirm"));
            createUiWatcherIsAssert(solo,UN,"e5",Selector.textContains("异常").resourceId("com.hnrmb.salary:id/tv_content"),Selector.resourceId("com.hnrmb.salary:id/btn_single_confirm"));
            createUiWatcherIsAssert(solo,UN,"e4",Selector.textContains("错误").resourceId("com.hnrmb.salary:id/dialog_content_info"),Selector.resourceId("com.hnrmb.salary:id/btn_single_confirm"));
        }
        /**
        for (final UiSelector item : list){
            uiDevice.registerWatcher(WatcherName.pop(), new UiWatcher() {
                @Override
                public boolean checkForCondition(){
                    UiObject uiObject = UN.findUiobject(item);
                    if (uiObject.exists()){
                        Operate.justClick(uiObject,false);
                        return true;
                    }
                    return false;
                }
            });
        }
         **/


    }

    public static JSONObject createEleJson(String Name,UiSelector selector,UiSelector selector2){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name",Name);
            jsonObject.put("expect",selector);
            jsonObject.put("click",selector2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static void createUiWatcher(final Solo solo, final UiObjectNew UN, String Name, final UiSelector expect, final UiSelector clickob){
        solo.getMydevice().registerWatcher(Name, new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                UiObject item = UN.findUiobject(expect);
                if(item.exists()){
                    LogInfo.w("匹配到异常元素："+expect.toString());
                    Operate.justClick(UN.findUiobject(clickob),false);
                    return true;
                }
                return false;
            }
        });
    }

    public static void createUiWatcherIsAssert(final Solo solo, final UiObjectNew UN, String Name, final UiSelector expect, final UiSelector clickob){
        solo.getMydevice().registerWatcher(Name, new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                UiObject item = UN.findUiobject(expect);
                if(item.exists()){
                    LogInfo.w("匹配到异常元素："+expect.toString());
                    String e = null;
                    try {
                        e = item.getText();
                    } catch (UiObjectNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    if (Config.use_except == 0){
                        String PicName = DataInfo.getDayFormatForIMG();
                        new Pic().screenShotWithADB(PicName);
                        Bundle bundle = new Bundle();
                        bundle.putString("img",PicName);
                        new BundleNew(Solo.getInstance().getInstrumentation()).sendStatus(10,bundle);
                        Bundle bundle1 = new Bundle();
                        bundle1.putString("stack","出现一个异常："+e);
                        new BundleNew(Solo.getInstance().getInstrumentation()).sendStatus(11,bundle);
                        Config.use_except +=1;
                    }
                    Operate.justClick(UN.findUiobject(clickob),false);
                    return true;
                }
                return false;
            }
        });
    }

    public static void update(final Solo solo){
        /**
         * 处理升级弹框
         */
        solo.getMydevice().registerWatcher("closeUpdate", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                UiObject item = UiObjectNew.getInstance(solo).findObjectForWathcer(new Ele[]{new Ele(Config.TYPE_ID,"com.hnrmb.salary:id/linear_close")});
                if(item.exists()){
                    Operate.justClick(item,false);
                    return true;
                }
                return false;
            }
        });
    }

    public static void closeTV(final Solo solo){
        /**
         * 处理广告弹框
         */
        solo.getMydevice().registerWatcher("closeTV", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                UiObject item = UiObjectNew.getInstance(solo).findObjectForWathcer(new Ele[]{new Ele(Config.TYPE_ID,"com.hnrmb.salary:id/iv_close")});
                if(item.exists()){
                    Operate.justClick(item,false);
                    return true;
                }
                return false;
            }
        });
    }

    public static void permissionAllow(final Solo solo){
        /**
         * 处理系统权限
         */
        solo.getMydevice().registerWatcher("permission", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                UiObject item = UiObjectNew.getInstance(solo).findObjectForWathcer(new Ele[]{new Ele(Config.TYPE_ID,"com.android.packageinstaller:id/permission_allow_button")});
                if(item.exists()){
                    Operate.justClick(item,false);
                    return true;
                }
                return false;
            }
        });
    }

    public static void cancelFinger(final Solo solo){
        /**
         * 处理指纹解锁弹框
         */
        solo.getMydevice().registerWatcher("cancelFinger", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                UiObjectNew UN = UiObjectNew.getInstance(solo);
                UiObject item = UN.findObjectForWathcer(new Ele[]{new Ele(Config.TYPE_ID,"com.hnrmb.salary:id/warn_cancel"),new Ele(Config.TYPE_TEXT,"取消")});;
                if(item.exists()){
                    Operate.justClick(item,false);
                    Operate.justClick(UN.findObjectForWathcer(new Ele[]{new Ele(Config.TYPE_ID,"com.hnrmb.salary:id/btn_single_confirm"),new Ele(Config.TYPE_TEXT,"确定")}),false);
                    return true;
                }
                return false;
            }
        });
    }



}
