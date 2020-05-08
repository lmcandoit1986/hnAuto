package com.hnrmb.Page;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;
/**
 * 银行+页面元素及操作封装
 * 规范：
 * 1、元素定位，以object开头
 * 2、操作，以action开头
 * 3、验证，以assert开头
 */
public class BankList {

    public Solo solo;
    public UiObjectNew UN;
    public BankList(Solo so) {
        solo = so;
        UN = UiObjectNew.getInstance(solo);
    }

    public BankList assertNomal(){
        UN.findObjectNew(Config.TYPE_TEXT,"市场");
        return this;
    }

    public BankProduct actionIntoDetail(String PName){
        Operate.clickAndWaitForNewWindow(UN.findObjectNew(Config.TYPE_TEXT,PName));
        return new BankProduct(solo);
    }

}