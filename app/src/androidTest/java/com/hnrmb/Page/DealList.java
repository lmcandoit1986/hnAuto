package com.hnrmb.Page;

import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Selector;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;

public class DealList {
    public Solo solo;
    public UiObjectNew UN;
    public DealList(Solo solo) {
        this.solo = solo;
        UN = UiObjectNew.getInstance(solo);
    }

    public DealList assertTitle(){
        Operate.assertWaitForExists(UN.findUiobject(Selector.resourceId("com.hnrmb.salary:id/head_content_tv").text("交易明细")),10);
        return this;
    }

    public CiticAcount actionBack(){
        Operate.click(UN.findUiobject(Selector.resourceId("com.hnrmb.salary:id/head_left_lay")));
        return new CiticAcount(solo);
    }

}
