package com.hnrmb.Page;

import android.graphics.Path;

import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiScrollable;

import com.alibaba.fastjson.JSONObject;
import com.hnrmb.Config.Config;
import com.hnrmb.Server.APIForUITest;
import com.hnrmb.Utils.DeviceInfo;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.UiObjectNew;

public class GoodsList {

    public static final String id_listview = "com.hnrmb.salary:id/xrecycler_home";

    /**
     * 元素定位，通过列表获取
     * @param text
     * @return
     */
    private static UiObject locationByTextInList(String text){
        return new UiObjectNew().findObjectInListView(Config.TYPE_ID,id_listview,text);
    }

    private static UiObject orderEntry(){
        return new UiObjectNew().findObjectNew(Config.TYPE_TEXT,"我的");
    }

    private static UiScrollable locationList(){
        return new UiObjectNew().findListViewObject(Config.TYPE_ID,id_listview);
    }

    private static UiObject findNoMore(){
        return new UiObjectNew().findObjectNew(Config.TYPE_TEXT,"美好生活 云成相伴");
    }

    public static String getGoodsOnSale(){
        for(int i=1;i<10;i++){
            JSONObject listJson = APIForUITest.goodsDetail(i);
            // 判断商品是否售罄
            if(true) return "Name";
        }
        return null;

    }

    public static String getGoodsOffSale(){
        for(int i=1;i<10;i++){
            JSONObject listJson = APIForUITest.goodsDetail(i);
            // 判断商品是否售罄
            if(true) return "Name";
        }
        return null;

    }

    /**
     * 列表点击商品跳转到商品详情
     * @param text
     */
    public static void intentItemDetail(String text){
        Operate.click(locationByTextInList(text));
    }

    /**
     * 下拉刷新
     */
    public static void loadAgain(){
        Operate.swipe(DeviceInfo.getInstance().getMydevice(),Config.DOWN,5);
    }

    /**
     * 切换到我的tab
     */
    public static void intoOrderList(){
        Operate.click(orderEntry());
    }

    /**
     * 校验列表元素
     */
    public static void checkListItem() {
        JSONObject listJson = APIForUITest.goodsList(1);
        // 校验列表商品名称、价格

    }

    /**
     * 校验第二页数据加载
     */
    public static void checkListNextPageItem() {
        JSONObject listJson = APIForUITest.goodsList(2);
        // 校验第二页的数据是否存在
    }

    /**
     * 滑动列表到底部
     */
    public static void checkListBottom() {
        Operate.flingToListEnd(locationList(),20);
        findNoMore();
    }

    /**
     * 双列banner 第一个位置跳转
     */
    public static void banner2_1() {
        Operate.click(new UiObjectNew().findObjectNew(Config.TYPE_ID,"com.hnrmb.salary:id/sdv_life_img_one"));
    }

    /**
     * 双列banner 第二个位置跳转
     */
    public static void banner2_2() {
        Operate.click(new UiObjectNew().findObjectNew(Config.TYPE_ID,"com.hnrmb.salary:id/sdv_life_img_two"));
    }
}
