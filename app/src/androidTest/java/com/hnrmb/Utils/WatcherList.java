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
                if(item.exists()){
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
                if(item.exists()){
                    Operate.click(item,false);
                    return true;
                }
                return false;
            }
        });
    }



}
