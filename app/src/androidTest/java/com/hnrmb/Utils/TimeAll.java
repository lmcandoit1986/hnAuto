package com.hnrmb.Utils;

/**
 * Created by liming on 2020/3/24.
 */

public class TimeAll {

    public static void sleepTread(long l){
        LogInfo.i("sleep "+l);
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
