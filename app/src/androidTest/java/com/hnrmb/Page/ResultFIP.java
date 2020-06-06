package com.hnrmb.Page;

import androidx.test.uiautomator.UiObject;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.DataInfo;
import com.hnrmb.Utils.FailedCase;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;

public class ResultFIP {
    public Solo solo;
    public UiObjectNew UN;
    public ResultFIP(Solo so) {
        solo = so;
        UN = UiObjectNew.getInstance(so);
    }

    public ResultFIP assertIsResultPage(){
        Operate.assertWaitForExists(UN.findObjectNew(Config.TYPE_TEXT,"结果详情"),5);
        return this;
    }

    public MyFIP actionFinish(){
        Operate.clickAndWaitForNewWindow(UN.findObjectNew(Config.TYPE_ID,"com.hnrmb.salary:id/head_right_lay"));
        return new MyFIP(solo);
    }

}
