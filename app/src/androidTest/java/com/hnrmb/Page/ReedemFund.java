package com.hnrmb.Page;

import androidx.test.uiautomator.UiObject;

import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Selector;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;

public class ReedemFund {

    public Solo solo;
    public UiObjectNew UN;
    public ReedemFund(Solo solo) {
        this.solo = solo;
        UN = UiObjectNew.getInstance(solo);
    }

    public PassWordNative actionSureSuccess(Boolean realTime){
        if (!realTime){
            Operate.click(UN.findUiobject(Selector.text("普通赎回")));
        }else{
            Operate.click(UN.findUiobject(Selector.text("实时赎回")));
        }
        Operate.click(UN.findUiobject(Selector.text("确认赎回")));
        Operate.click(UN.findUiobject(Selector.text("确认赎回")),false,0,0);
        if(!realTime){
            Operate.assertWaitForExists(UN.findUiobject(Selector.text("是否确认赎回")),5);
            Operate.click(UN.findUiobject(Selector.text("确认赎回").resourceId("com.hnrmb.salary:id/warn_confirm")));
        }
        return new PassWordNative(solo);
    }

    public ReedemFund actionSetMoney(String Money){
        UiObject edit = UN.findUiobject(Selector.resourceId("com.hnrmb.salary:id/transfer_out_money"));
        Operate.input(edit,Money);
        return this;
    }


}
