package com.hnrmb.Cases;

import com.hnrmb.Config.Config;
import com.hnrmb.Page.GoodsDetail;
import com.hnrmb.Page.GoodsList;
import com.hnrmb.Server.APIForUITest;
import com.hnrmb.Utils.CaseInfo;
import com.hnrmb.Utils.UiObjectNew;

import org.junit.Test;

public class Goods extends BaseCase{

    @Test
    public void loadAgain(){
        CaseInfo.setCaseDesc("下拉刷新列表功能");
        GoodsList.loadAgain();
    }

    @Test
    public void checkListDetail(){
        CaseInfo.setCaseDesc("检查列表元素");
        GoodsList.checkListItem();
    }

    @Test
    public void checkNextPageItem(){
        CaseInfo.setCaseDesc("验证列表翻页加载");
        GoodsList.checkListNextPageItem();
    }

    @Test
    public void checkListBottom(){
        CaseInfo.setCaseDesc("验证列表滑动到底部");
        GoodsList.checkListBottom();
    }

    @Test
    public void banner1TrunCheck(){
        CaseInfo.setCaseDesc("轮播banner跳转检测");
    }

    @Test
    public void banner_2_1_TrunCheck(){
        CaseInfo.setCaseDesc("双列banner第一个位置跳转检测");
        GoodsList.banner2_1();
    }

    @Test
    public void banner_2_2_TrunCheck(){
        CaseInfo.setCaseDesc("双列banner第二个位置跳转检测");
        GoodsList.banner2_2();
    }

    @Test
    public void checkGoodsDetailOnSale(){
        CaseInfo.setCaseDesc("验证在售商品详情页面");
        GoodsList.intentItemDetail(GoodsList.getGoodsOnSale());
        GoodsDetail.AssertOnSale();
    }

    @Test
    public void checkGoodsDetailOnStock(){
        CaseInfo.setCaseDesc("验证售罄商品详情页面");
        GoodsList.intentItemDetail(GoodsList.getGoodsOffSale());
        GoodsDetail.AssertOffSale();
    }

}
