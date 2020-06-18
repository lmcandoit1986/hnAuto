package com.hnrmb.Page;

import androidx.test.uiautomator.UiObject;

import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Selector;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;

public class FIPHistoryOrder {
    public Solo solo;
    public UiObjectNew UN;
    public FIPHistoryOrder(Solo solo) {
        this.solo = solo;
        UN = UiObjectNew.getInstance(solo);
    }

    public FIPHistoryOrder assertTitle(){
        Operate.assertWaitForExists(UN.findUiobject(Selector.resourceId("com.hnrmb.salary:id/tv_toolbar_title").text("历史资产")),10);
        return this;
    }

    public FIPHistoryOrder assertTag(){
        Operate.assertWaitForExists(UN.findUiobject(Selector.text("已到期").resourceId("com.hnrmb.salary:id/tv_tag")),5);
        return this;
    }

    public FIPTradeDetail actionIntoTradeDetail(){
        UiObject item = UN.findUiobject(Selector.resourceId("com.hnrmb.salary:id/tv_name"));
        String name = Operate.getText(item);
        Operate.click(item);
        return new FIPTradeDetail(solo,name);
    }



}
