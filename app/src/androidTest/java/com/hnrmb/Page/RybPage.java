package com.hnrmb.Page;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.Ele;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Selector;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;

public class RybPage {

    public Solo solo;
    public UiObjectNew UN;
    public RybPage(Solo so){
        solo = so;
        UN = UiObjectNew.getInstance(solo);
    }

    public RybPage assertNomal(){
        UN.findUiobject(new Ele[]{new Ele(Config.TYPE_ID,"com.hnrmb.salary:id/head_content_tv"),new Ele(Config.TYPE_TEXT,"工资宝")});
        return this;
    }

    public BuyRyb actionBuy(){
        Operate.click(UN.findUiobject(Selector.className("android.widget.Button").text("购买")),true,15,15);
        return new BuyRyb(solo);
    }

    public ReedemRyb actionRedeem(){
        Operate.click(UN.findUiobject(Selector.className("android.widget.Button").text("赎回")),true,15,15);
        return new ReedemRyb(solo);
    }
}
