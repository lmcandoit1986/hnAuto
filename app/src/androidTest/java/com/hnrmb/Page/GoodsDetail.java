package com.hnrmb.Page;

import androidx.test.uiautomator.UiObjectNotFoundException;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.DataInfo;
import com.hnrmb.Utils.DeviceInfo;
import com.hnrmb.Utils.FailedCase;
import com.hnrmb.Utils.UiObjectNew;

public class GoodsDetail {

    //com.hnrmb.salary:id/tv_buy

    private static String getBuyText(){
        try {
            return new UiObjectNew().findObjectNew(Config.TYPE_ID,"com.hnrmb.salary:id/tv_buy").getText();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
            FailedCase.InterruptProcess();
        }
        return null;
    }

    public static void AssertOnSale(){
        if (!getBuyText().equals("立即购买")) FailedCase.InterruptProcess("match wrong status", DataInfo.getDayFormatForIMG());
    }

    public static void AssertOffSale(){
        if (!getBuyText().equals("已售罄")) FailedCase.InterruptProcess("match wrong status", DataInfo.getDayFormatForIMG());
    }

}
