package com.hnrmb.Page;

import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;

public class FIPTradeDetail {
    public Solo solo;
    public UiObjectNew UN;
    public FIPTradeDetail(Solo solo) {
        this.solo = solo;
        UN = UiObjectNew.getInstance(solo);
    }
}
