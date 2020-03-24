package com.hnrmb.Utils;

import android.util.Log;

/**
 * Created by liming on 2020/3/24.
 */

public class LogInfo {

    public static String TAG = "qatest";

    public static void i(String l){
        Log.i(TAG,l);
    }

    public static void d(String l){
        Log.d(TAG,l);
    }

    public static void e(String l){
        Log.e(TAG,l);
    }

    public static void w(String l){
        Log.w(TAG,l);
    }

}
