package com.hnrmb.Utils;

import android.os.RemoteException;

import androidx.test.uiautomator.UiDevice;

import com.hnrmb.Config.Config;

public class DeviceStatus {

    public static void wakeUp(UiDevice device){
        try {
            if (!device.isScreenOn()){
                device.wakeUp();
                // 如果有锁屏，执行解锁操作
                Operate.swipe(device, Config.UP,2);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
