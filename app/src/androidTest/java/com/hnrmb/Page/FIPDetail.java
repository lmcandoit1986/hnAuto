package com.hnrmb.Page;

import androidx.test.uiautomator.UiObject;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.TimeAll;
import com.hnrmb.Utils.UiObjectNew;
/**
 * 理财详情页面元素及操作封装
 * 规范：
 * 1、元素定位，以object开头
 * 2、操作，以action开头
 * 3、验证，以assert开头
 */
public class FIPDetail {

    public Solo solo;
    public UiObjectNew UN;
    public FIPDetail(Solo so) {
        solo = so;
        UN = UiObjectNew.getInstance(solo);
    }

    private final String back_id = "com.hnrmb.salary:id/head_left_lay";
    private final String title_id = "com.hnrmb.salary:id/head_content_tv";
    private final String buy_class = "android.widget.Button";


    private UiObject objectBack(){
        return UN.findObjectNew(Config.TYPE_ID,back_id);
    }

    private UiObject objectBuy(){
        return UN.findObjectByClass(Config.TYPE_TEXT,"热卖中",buy_class);
    }
    // 返回
    public FIPList actionBack(){
        Operate.click(objectBack());
        return new FIPList(solo);
    }
    // 购买
    public BuyFIP actionBuy(){
        Operate.click(objectBuy());
        return new BuyFIP(solo);
    }


    // 用于监控
    public FIPDetail assertNomal(){
        UN.assertWebelementIsDisplay(UN.findObjectNew(Config.TYPE_TEXT,"预期年化收益率"));
        return this;
    }
}
