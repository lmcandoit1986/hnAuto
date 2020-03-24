package com.hnrmb.Cases;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.UiObjectNew;

import org.junit.Test;

public class Goods extends BaseCase{

    @Test
    public void JXCheck(){
        new UiObjectNew().findObjectInListView(Config.TYPE_ID,"com.hnrmb.salary:id/xrecycler_home","测试时间");
    }

}
