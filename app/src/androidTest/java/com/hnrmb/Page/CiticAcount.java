package com.hnrmb.Page;

import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;

public class CiticAcount {
    public Solo solo;
    public UiObjectNew UN;
    public CiticAcount(Solo solo) {
        this.solo = solo;
        UN = UiObjectNew.getInstance(solo);
    }
}
