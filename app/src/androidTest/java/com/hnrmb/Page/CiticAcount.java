package com.hnrmb.Page;

import androidx.test.uiautomator.UiObject;

import com.hnrmb.Utils.DataInfo;
import com.hnrmb.Utils.FailedCase;
import com.hnrmb.Utils.MathsObj;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Selector;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;

public class CiticAcount {
    public Solo solo;
    public UiObjectNew UN;
    public CiticAcount(Solo solo) {
        this.solo = solo;
        UN = UiObjectNew.getInstance(solo);
    }

    private final String title_id = "com.hnrmb.salary:id/tv_toolbar_title";
    private final String back_id = "com.hnrmb.salary:id/iv_toolbar_back";
    private final String all_money = "com.hnrmb.salary:id/tv_money";
    private final String detail = "com.hnrmb.salary:id/tv_tips";
    private final String out_id = "com.hnrmb.salary:id/linear_transfer_out";
    private final String in_id = "com.hnrmb.salary:id/linear_transfer_in";
    private final String deal = "交易明细";
    private final String bankCard = "绑定银行卡";
    private final String phone = "预留手机号";

    private UiObject objectTitle(String title){return UN.findUiobject(Selector.resourceId(title_id).text(title));}
    private UiObject objectBack(){return UN.findUiobject(Selector.resourceId(back_id));}
    private UiObject objectAllMoney(){return UN.findUiobject(Selector.resourceId(all_money));}
    private UiObject objectDetail(){return UN.findUiobject(Selector.resourceId(detail));}
    private UiObject objectOut(){return UN.findUiobject(Selector.resourceId(out_id));}
    private UiObject objectIn(){return UN.findUiobject(Selector.resourceId(in_id));}
    private UiObject objectDeal(){return UN.findUiobject(Selector.text(deal));}
    private UiObject objectBank(){return UN.findUiobject(Selector.text(bankCard));}
    private UiObject objectPhone(){return UN.findUiobject(Selector.text(phone));}

    public CiticAcount assertTitle(){
        Operate.assertWaitForExists(objectTitle("理财账户"),5);
        return this;
    }

    public CiticAcount assertMoney(){
        if(!MathsObj.assertInt(Operate.getText(objectAllMoney()))) FailedCase.interruptProcess("总金额格式不符合预期", DataInfo.getDayFormatForIMG());
        return this;
    }

    public TransferOut actionOut(){
        Operate.click(objectOut());
        return new TransferOut(solo);
    }

    public TransferIn actionIn(){
        Operate.click(objectIn());
        return new TransferIn(solo);
    }

    public DealList actionDeal(){
        Operate.click(objectDeal());
        return new DealList(solo);
    }

    public CiticAcount actionDetail(){
        Operate.click(objectDetail());
        Operate.assertWaitForExists(UN.findUiobject(Selector.textMatch("总    金    额：.*元")),5);
        Operate.assertWaitForExists(UN.findUiobject(Selector.textMatch("可 用 金 额 ：.*元")),5);
        Operate.assertWaitForExists(UN.findUiobject(Selector.textMatch("冻 结 金 额 ：.*元")),5);
        Operate.click(UN.findUiobject(Selector.resourceId("com.hnrmb.salary:id/tv_ok").text("知道了")));
        return this;
    }



}
