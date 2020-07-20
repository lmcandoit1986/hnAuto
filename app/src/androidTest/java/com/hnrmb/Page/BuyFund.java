package com.hnrmb.Page;

import androidx.test.uiautomator.UiObject;

import com.hnrmb.Utils.DataInfo;
import com.hnrmb.Utils.LogInfo;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Selector;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;

public class BuyFund {
    public Solo solo;
    public UiObjectNew UN;
    public BuyFund(Solo so) {
        solo = so;
        UN = UiObjectNew.getInstance(so);
        long end = DataInfo.getTime() +5;
        while (true){
            if (Operate.assertWaitForExists(UN.findUiobject(Selector.text("收益规则")),5)){
                break;
            }
            if(DataInfo.getTime() > end){
                LogInfo.w("超5秒，页面加载未完成");
                break;
            }
        }
    }

    public BuyFund actionSetMoney(String Money){
        UiObject edit = UN.findUiobject(Selector.resourceId("com.hnrmb.salary:id/transfer_out_money"));
        Operate.input(edit,Money);
        return this;
    }

    public PassWordNative actionSureSuccess(){
        Operate.click(UN.findUiobject(Selector.resourceId("com.hnrmb.salary:id/transfer_out_submit")));
        Operate.click(UN.findUiobject(Selector.text("确认购买")));
        return new PassWordNative(solo);
    }

    public BuyFund actionSureWithExcept(){
        Operate.click(UN.findUiobject(Selector.resourceId("com.hnrmb.salary:id/transfer_out_submit")));
        return this;
    }

    public BuyFund assertBuyMoreThanHave(){
        Operate.assertWaitForExists(UN.findUiobject(Selector.text("晋商电子账户余额不足，请充值后购买")),3);
        return this;
    }
}
