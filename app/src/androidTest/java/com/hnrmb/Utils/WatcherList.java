package com.hnrmb.Utils;

import android.graphics.Path;

import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.UiWatcher;

import com.hnrmb.Config.Config;

public class WatcherList {

    public static void allException(final Solo solo){
        final UiObjectNew UN = UiObjectNew.getInstance(solo);
        UiDevice uiDevice = solo.getMydevice();
        Ele[] EleList = new Ele[5];
        EleList[0]=new Ele(Config.TYPE_ID,"com.hnrmb.salary:id/linear_close");
        EleList[2]=new Ele(Config.TYPE_ID,"com.hnrmb.salary:id/iv_close");
        EleList[3]=new Ele(Config.TYPE_ID,"com.android.packageinstaller:id/permission_allow_button");
        EleList[1]=new Ele(Config.TYPE_ID,"com.hnrmb.salary:id/warn_cancel");
        EleList[4]=new Ele(Config.TYPE_ID,"com.hnrmb.salary:id/btn_single_confirm");
        for (final Ele item : EleList){
            uiDevice.registerWatcher(item.getValue(), new UiWatcher() {
                @Override
                public boolean checkForCondition(){
                    UiObject uiObject = UN.findUiobject(new Ele[]{item});
                    if (uiObject.exists()){
                        Operate.justClick(uiObject,false);
                        return true;
                    }
                    return false;
                }
            });
        }

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
