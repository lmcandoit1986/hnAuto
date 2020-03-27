package com.hnrmb.Utils;

import android.os.Bundle;

public class CaseInfo {

    /**
     * 将case 描述信息输出
     * @param desc
     */
    public static void setCaseDesc(String desc){
        Bundle bundle = new Bundle();
        bundle.putString("desc",desc);
        new BundleNew(DeviceInfo.getInstance().getInstrumentation()).sendStatus(7,bundle);
    }

    public static void caseUseTime(String desc){
        Bundle bundle = new Bundle();
        bundle.putString("time",desc);
        new BundleNew(DeviceInfo.getInstance().getInstrumentation()).sendStatus(7,bundle);
    }
}
