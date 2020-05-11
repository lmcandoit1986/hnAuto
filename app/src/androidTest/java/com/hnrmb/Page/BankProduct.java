package com.hnrmb.Page;

import androidx.test.uiautomator.UiObject;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.TimeAll;
import com.hnrmb.Utils.UiObjectNew;
/**
 * 银行+产品详情页面元素及操作封装
 * 规范：
 * 1、元素定位，以object开头
 * 2、操作，以action开头
 * 3、验证，以assert开头
 */
public class BankProduct {

    private final String back_id = "com.hnrmb.salary:id/head_left_lay";

    public Solo solo;
    public UiObjectNew UN;
    public BankProduct(Solo so) {
        solo = so;
        UN = UiObjectNew.getInstance(solo);
    }

    private UiObject objectBack(){
        return UN.findObjectNew(Config.TYPE_ID,back_id);
    }

    public BankList actionBack(){
        Operate.clickAndWaitForNewWindow(objectBack());
//        TimeAll.sleepTread(2000);
        return new BankList(solo);
    }


    // 监控用
    public BankProduct assertNomal(){
        /**
         * 适用中关村产品
         */
        UN.assertWebelementIsDisplay(UN.findObjectNew(Config.TYPE_TEXT,"派息利率"));
        return this;
    }

    public BankProduct assertNomal(int i){
        /**
         * 适用民生产品
         */
        UN.assertWebelementIsDisplay(UN.findObjectNew(Config.TYPE_TEXT,"七日年化收益率"));
        return this;
    }

}
