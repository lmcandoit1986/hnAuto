package com.hnrmb.Utils;

import androidx.test.uiautomator.UiDevice;

/**
 * Created by liming on 2020/3/24.
 */

public class TimeAll {

    private static final long waitForIdleTimeOut = 1000;//毫秒

    public static void sleepTread(long l){
        LogInfo.i("sleep "+l);
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
