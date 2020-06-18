package com.hnrmb.Page;

import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Selector;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;

public class FIPTradeDetail {
    public Solo solo;
    public UiObjectNew UN;
    public String FIP = null;
    public FIPTradeDetail(Solo solo,String title) {
        this.solo = solo;
        UN = UiObjectNew.getInstance(solo);
        FIP = title;
    }

    public FIPTradeDetail assertTitle(){
        Operate.assertWaitForExists(UN.findUiobject(Selector.resourceId("com.hnrmb.salary:id/tv_toolbar_title").text("交易详情")),10);
        return this;
    }

    public FIPTradeDetail assertFIPName(){
        Operate.assertWaitForExists(UN.findUiobject(Selector.text(FIP).resourceId("com.hnrmb.salary:id/lcb_name_tv")),5);
        return this;
    }

    public MyFIP actionBack(){
        Operate.click(UN.findUiobject(Selector.resourceId("com.hnrmb.salary:id/head_left_lay")));
        return new MyFIP(solo);
    }

    public FIPDetail actionIntoFIPDetail(){
        Operate.click(UN.findUiobject(Selector.text("产品详情").resourceId("com.hnrmb.salary:id/lcb_detail_tv")));
        return new FIPDetail(solo,FIP);
    }
}
