package com.hnrmb.Page;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.Ele;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;

public class Pay {

    public Solo solo;
    public UiObjectNew UN;
    public Pay(Solo so){
        solo = so;
        UN = UiObjectNew.getInstance(solo);
    }

    public Pay assertNomal(){
        UN.findUiobject(new Ele[]{new Ele(Config.TYPE_ID,"com.hnrmb.salary:id/head_content_tv"),new Ele(Config.TYPE_TEXT,"工资宝")});
        return this;
    }
}
