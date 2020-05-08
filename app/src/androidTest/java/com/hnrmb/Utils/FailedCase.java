package com.hnrmb.Utils;

import android.os.Bundle;

/**
 * Created by liming on 2020/3/24.
 */

public class FailedCase {

    public static void interruptProcess(){
        throw new AssertionError();
    }

    public static void interruptProcess(String MSG){
        throw new AssertionError(MSG);
    }

    public static void interruptProcess(String MSG, String PicName){
        new Pic().screenShotWithADB(PicName);
        /**
         * 失败截图信息输出到窗口
         * INSTRUMENTATION_STATUS: img=imgName
         * INSTRUMENTATION_STATUS_CODE: 10
         */
        Bundle bundle = new Bundle();
        bundle.putString("img",PicName);
        new BundleNew(Solo.getInstance().getInstrumentation()).sendStatus(10,bundle);
        throw new AssertionError(MSG);
    }


}
