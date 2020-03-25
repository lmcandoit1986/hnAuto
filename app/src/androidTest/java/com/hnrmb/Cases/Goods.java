package com.hnrmb.Cases;

import com.alibaba.fastjson.JSONObject;
import com.hnrmb.Page.GoodsDetail;
import com.hnrmb.Page.GoodsList;
import com.hnrmb.Utils.CaseInfo;

import org.junit.Test;

public class Goods extends BaseCase{

    @Test
    public void loadAgain(){
        CaseInfo.setCaseDesc("下拉刷新列表功能");
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
        GoodsList.assertListNextPageItem();
    }

    @Test
    public void checkListBottom(){
        CaseInfo.setCaseDesc("验证列表滑动到底部");
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
        GoodsList.actionBanner2_1();
    }

    @Test
    public void banner_2_2_TrunCheck(){
        CaseInfo.setCaseDesc("双列banner第二个位置跳转检测");
        GoodsList.actionBanner2_2();
    }

    @Test
    public void checkGoodsDetailOnSale(){
        CaseInfo.setCaseDesc("验证在售商品详情页面");
        JSONObject jsonObject = GoodsList.getGoodsOnSale();
        GoodsList.actionItem(jsonObject.getString("name"));
        GoodsDetail.assertOnSale();
    }

    @Test
    public void checkGoodsDetailOnStock(){
        CaseInfo.setCaseDesc("验证售罄商品详情页面");
        JSONObject jsonObject = GoodsList.getGoodsOffSale();
        GoodsList.actionItem(jsonObject.getString("name"));
        GoodsDetail.assertOffSale();
    }

    @Test
    public void checkGoodsDetail(){
        CaseInfo.setCaseDesc("验证商品信息:名称，描述，价格");
        JSONObject jsonObject = GoodsList.getGoodsOnSale();
        GoodsList.actionItem(jsonObject.getString("name"));
        GoodsDetail.assertItemInfo(jsonObject.getInteger("id"));
    }



}
