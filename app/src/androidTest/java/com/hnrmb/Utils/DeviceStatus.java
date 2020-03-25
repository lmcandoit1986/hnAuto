package com.hnrmb.Utils;

import android.os.RemoteException;

import androidx.test.uiautomator.UiDevice;

public class DeviceStatus {

    public static void wakeUp(UiDevice device){
        try {
            if (!device.isScreenOn()){
                device.wakeUp();
                // 如果有锁屏，执行解锁操作
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
