package com.hnrmb.Cases;

import com.alibaba.fastjson.JSONObject;
import com.hnrmb.Cases.Base.GoodsBase;
import com.hnrmb.Server.PageAPI.GoodsListAPI;
import com.hnrmb.Utils.CaseInfo;


import org.junit.Test;

public class Goods extends GoodsBase {

    @Test
    public void loadAgain(){
        CaseInfo.setCaseDesc("下拉刷新列表功能");
        goodsList.actionLoadAgain();
    }

    @Test
    public void checkListDetail(){
        CaseInfo.setCaseDesc("检查列表元素");
        goodsList.assertListItem();
    }

    @Test
    public void checkNextPageItem(){
        CaseInfo.setCaseDesc("验证列表翻页加载");
        goodsList.actionScrollForward(5).assertListNextPageItem();
    }

    @Test
    public void checkListBottom(){
        CaseInfo.setCaseDesc("验证列表滑动到底部");
        goodsList.actionScrollToListBottom().assertNoMore();
    }

    @Test
    public void banner1TrunCheck(){
        CaseInfo.setCaseDesc("轮播banner跳转检测");
    }

    @Test
    public void banner_2_1_TrunCheck(){
        CaseInfo.setCaseDesc("双列banner第一个位置跳转检测");
        JSONObject JS = GoodsListAPI.getBannerJsonData(1);
        goodsList.actionBanner2_1().assertBannerTurn(JS);
    }

    @Test
    public void banner_2_2_TrunCheck(){
        CaseInfo.setCaseDesc("双列banner第二个位置跳转检测");
        JSONObject JS = GoodsListAPI.getBannerJsonData(2);
        goodsList.actionBanner2_2().assertBannerTurn(JS);
    }

    //@Test
    public void bannerTrunCheck() {
        CaseInfo.setCaseDesc("双列banner第二个位置跳转检测");
        // 暂不能有效控制跳转位置，无法判断是点击跳转的第几个Banner
    }

    @Test
    public void checkGoodsDetailOnSale(){
        CaseInfo.setCaseDesc("验证在售商品详情页面");
        JSONObject jsonObject = GoodsListAPI.getGoodsOnSale();
        goodsList.actionItem(jsonObject.getString("name")).assertOnSale();
    }

    @Test
    public void checkGoodsDetailNoStock(){
        CaseInfo.setCaseDesc("验证售罄商品详情页面");
        JSONObject jsonObject = GoodsListAPI.getGoodsOffSale();
        String GoodName = jsonObject.getString("name");
        goodsList.actionScrollToListExpectObject(GoodName).actionItemOnCurrentShow(GoodName).assertOffSale();
    }

    @Test
    public void checkGoodsDetailNameAndDesc(){
        CaseInfo.setCaseDesc("验证商品信息:名称，描述");
        JSONObject jsonObject = GoodsListAPI.getGoodsOnSale();
        String GoodName = jsonObject.getString("name");
        int GoodId = jsonObject.getInteger("id");
        goodsList.actionScrollToListExpectObject(GoodName).actionItemOnCurrentShow(GoodName).assertName(GoodId).assertDesc(GoodId);
    }

    @Test
    public void checkGoodsDetailPriceOne(){
        CaseInfo.setCaseDesc("验证商品信息:价格一致");
        JSONObject jsonObject = GoodsListAPI.getGoodsMinIsEqualMax();
        String GoodName = jsonObject.getString("name");
        int GoodId = jsonObject.getInteger("id");
        goodsList.actionScrollToListExpectObject(GoodName).actionItemOnCurrentShow(GoodName).assertPrice(GoodId);
    }

    @Test
    public void checkGoodsDetailPriceTwo(){
        CaseInfo.setCaseDesc("验证商品信息:有价格区间");
        JSONObject jsonObject = GoodsListAPI.getGoodsMinIsNotEqualMax();
        String GoodName = jsonObject.getString("name");
        int GoodId = jsonObject.getInteger("id");
        goodsList.actionScrollToListExpectObject(GoodName).actionItemOnCurrentShow(GoodName).assertPrice(GoodId);

    }

    @Test
    public void checkGoodsListPriceOne(){
        CaseInfo.setCaseDesc("验证列表商品信息:价格一致");
        JSONObject jsonObject = GoodsListAPI.getGoodsMinIsEqualMax();
        String GoodName = jsonObject.getString("name");
        goodsList.actionScrollToListExpectObject(GoodName).assertPrice(jsonObject);

    }

    @Test
    public void checkGoodsListPriceTwo(){
        CaseInfo.setCaseDesc("验证列表商品信息:有价格区间");
        JSONObject jsonObject = GoodsListAPI.getGoodsMinIsNotEqualMax();
        String GoodName = jsonObject.getString("name");
        goodsList.actionScrollToListExpectObject(GoodName).assertPrice(jsonObject);

    }



}
