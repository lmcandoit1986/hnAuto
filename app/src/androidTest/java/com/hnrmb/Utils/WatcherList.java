package com.hnrmb.Utils;

import android.graphics.Path;

import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.UiWatcher;

import com.hnrmb.Config.Config;

public class WatcherList {

    public static void update(final Solo solo){
        solo.getMydevice().registerWatcher("closeUpdate", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                UiObject item = UiObjectNew.getInstance(solo).findObjectNew(Config.TYPE_ID,"com.hnrmb.salary:id/linear_close",false);
                if(item!=null){
                    Operate.click(item,false);
                    return true;
                }
                return false;
            }
        });
    }

    public static void closeTV(final Solo solo){
        solo.getMydevice().registerWatcher("closeTV", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                UiObject item = UiObjectNew.getInstance(solo).findObjectNew(Config.TYPE_ID,"com.hnrmb.salary:id/iv_close",false);
                if(item!=null){
                    Operate.click(item,false);
                    return true;
                }
                return false;
            }
        });
    }

    public static void permissionAllow(final Solo solo){
        solo.getMydevice().registerWatcher("permission", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                UiObject item = UiObjectNew.getInstance(solo).findObjectNew(Config.TYPE_ID,"com.android.packageinstaller:id/permission_allow_button",false);
                if(item!=null){
                    Operate.click(item,false);
                    return true;
                }
                return false;
            }
        });
    }

    public static void cancelFinger(final Solo solo){
        solo.getMydevice().registerWatcher("cancelFinger", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                UiObjectNew UN = UiObjectNew.getInstance(solo);
                UiObject item = UN.findUiobject(new Ele[]{new Ele(Config.TYPE_ID,"com.hnrmb.salary:id/warn_cancel")},new Ele[]{new Ele(Config.TYPE_TEXT,"取消")},false);;
                if(item!=null){
                    Operate.click(item,false);
                    Operate.click(UN.findUiobject(new Ele[]{new Ele(Config.TYPE_ID,"com.hnrmb.salary:id/btn_single_confirm")},new Ele[]{new Ele(Config.TYPE_TEXT,"确定")},false),false);
                    return true;
                }
                return false;
            }
        });
    }



}
