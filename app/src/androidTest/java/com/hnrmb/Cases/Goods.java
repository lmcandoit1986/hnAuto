package com.hnrmb.Cases;

import androidx.test.uiautomator.UiObject;

import com.alibaba.fastjson.JSONObject;
import com.hnrmb.Config.Config;
import com.hnrmb.Page.GoodsDetail;
import com.hnrmb.Page.GoodsList;
import com.hnrmb.Utils.CaseInfo;
import com.hnrmb.Utils.LogInfo;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.UiObjectNew;

import org.junit.Test;

public class Goods extends BaseCase{

    @Test
    public void loadAgain(){
        CaseInfo.setCaseDesc("下拉刷新列表功能");
        GoodsList.actionItem("3种规格产品");
        GoodsList.actionLoadAgain();
    }

    @Test
    public void checkListDetail(){
        CaseInfo.setCaseDesc("检查列表元素");
        GoodsList.assertListItem();
    }

    @Test
    public void checkNextPageItem(){
        CaseInfo.setCaseDesc("验证列表翻页加载");
        GoodsList.actionScrollForward(5);
        GoodsList.assertListNextPageItem();
    }

    @Test
    public void checkListBottom(){
        CaseInfo.setCaseDesc("验证列表滑动到底部");
//        GoodsList.actionScrollToListBottom1();
        GoodsList.actionScrollToListBottom();
        GoodsList.assertNoMore();
    }

    @Test
    public void banner1TrunCheck(){
        CaseInfo.setCaseDesc("轮播banner跳转检测");
    }

    @Test
    public void banner_2_1_TrunCheck(){
        CaseInfo.setCaseDesc("双列banner第一个位置跳转检测");
        JSONObject JS = GoodsList.getBannerJsonData(1);
        LogInfo.i(JS.toString());
        GoodsList.actionBanner2_1();
        GoodsList.assertBannerTurn(JS);
    }

    @Test
    public void banner_2_2_TrunCheck(){
        CaseInfo.setCaseDesc("双列banner第二个位置跳转检测");
        JSONObject JS = GoodsList.getBannerJsonData(2);
        GoodsList.actionBanner2_2();
        GoodsList.assertBannerTurn(JS);
    }

    @Test
    public void checkGoodsDetailOnSale(){
        CaseInfo.setCaseDesc("验证在售商品详情页面");
        JSONObject jsonObject = GoodsList.getGoodsOnSale();
        GoodsList.actionItem(jsonObject.getString("name"));
        GoodsDetail.assertOnSale();
    }

    @Test
    public void checkGoodsDetailNoStock(){
        CaseInfo.setCaseDesc("验证售罄商品详情页面");
        JSONObject jsonObject = GoodsList.getGoodsOffSale();
        GoodsList.actionScrollToListExpectObject(jsonObject.getString("name"));
        GoodsList.actionItemOnCurrentShow(jsonObject.getString("name"));
        GoodsDetail.assertOffSale();
    }

    @Test
    public void checkGoodsDetailNameAndDesc(){
        CaseInfo.setCaseDesc("验证商品信息:名称，描述");
        JSONObject jsonObject = GoodsList.getGoodsOnSale();
        GoodsList.actionScrollToListExpectObject(jsonObject.getString("name"));
        GoodsList.actionItemOnCurrentShow(jsonObject.getString("name"));
        GoodsDetail.assertName(jsonObject.getInteger("id"));
        GoodsDetail.assertDesc(jsonObject.getInteger("id"));
    }

    @Test
    public void checkGoodsDetailPriceOne(){
        CaseInfo.setCaseDesc("验证商品信息:价格一致");
        JSONObject jsonObject = GoodsList.getGoodsMinIsEqualMax();
        GoodsList.actionScrollToListExpectObject(jsonObject.getString("name"));
        GoodsList.actionItemOnCurrentShow(jsonObject.getString("name"));
        GoodsDetail.assertPrice(jsonObject.getInteger("id"));

    }

    @Test
    public void checkGoodsDetailPriceTwo(){
        CaseInfo.setCaseDesc("验证商品信息:有价格区间");
        JSONObject jsonObject = GoodsList.getGoodsMinIsNotEqualMax();
        GoodsList.actionScrollToListExpectObject(jsonObject.getString("name"));
        GoodsList.actionItemOnCurrentShow(jsonObject.getString("name"));
        GoodsDetail.assertPrice(jsonObject.getInteger("id"));

    }



}
