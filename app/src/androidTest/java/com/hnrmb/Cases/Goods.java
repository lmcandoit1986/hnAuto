package com.hnrmb.Cases;

import com.hnrmb.Config.Config;
import com.hnrmb.Page.GoodsList;
import com.hnrmb.Utils.CaseInfo;
import com.hnrmb.Utils.UiObjectNew;

import org.junit.Test;

public class Goods extends BaseCase{

    @Test
    public void LoadAgain(){
        CaseInfo.setCaseDesc("下拉刷新列表功能");
        GoodsList.loadAgain();
    }

}
