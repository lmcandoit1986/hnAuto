package com.hnrmb.Page;

import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiScrollable;

import com.alibaba.fastjson.JSONObject;
import com.hnrmb.Config.Config;
import com.hnrmb.Server.APIForUITest;
import com.hnrmb.Utils.DeviceInfo;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.UiObjectNew;

/**
 * 好物 列表页面元素及操作封装
 *  * 规范：
 *  * 1、元素定位，以object开头
 *  * 2、操作，以action开头
 *  * 3、验证，以assert开头
 */

public class GoodsList {

    public static final String LIST_VIEW_ID = "com.hnrmb.salary:id/xrecycler_home"; // 好物列表整体
    public static final String BANNER_1_ID = "com.hnrmb.salary:id/sdv_life_img_one"; // 双列 Banner 1位置
    public static final String BANNER_2_ID = "com.hnrmb.salary:id/sdv_life_img_two"; // 双列 Banner 2位置

    /**
     * 定位列表中的商品，通过文本定位
     * @param text
     * @return
     */
    private static UiObject objectItemInList(String text){
        return new UiObjectNew().findObjectInListView(Config.TYPE_ID,LIST_VIEW_ID,text);
    }

    // 获取我的入口对象
    private static UiObject objectOrderEntry(){
        return new UiObjectNew().findObjectNew(Config.TYPE_TEXT,"我的");
    }

    // 获取商品列表对象
    private static UiScrollable objectList(){
        return new UiObjectNew().findListViewObject(Config.TYPE_ID,LIST_VIEW_ID);
    }

    // 获取列表底部没有更多的对象
    private static UiObject objectNoMore(){
        return new UiObjectNew().findObjectNew(Config.TYPE_TEXT,"美好生活 云成相伴");
    }

    // 获取商品列表中的在售的商品信息
    public static String getGoodsOnSale(){
        for(int i=1;i<10;i++){
            JSONObject listJson = APIForUITest.goodsDetail(i);
            // 判断商品是否售罄
            if(true) return "Name";
        }
        return null;

    }

    // 获取商品列表中售罄的商品信息
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
    public static void actionItem(String text){
        Operate.click(objectItemInList(text));
    }

    /**
     * 下拉刷新
     */
    public static void actionLoadAgain(){
        Operate.swipe(DeviceInfo.getInstance().getMydevice(),Config.DOWN,5);
    }

    /**
     * 切换到我的tab
     */
    public static void actionOrder(){
        Operate.click(objectOrderEntry());
    }

    /**
     * 校验列表元素
     */
    public static void assertListItem() {
        JSONObject listJson = APIForUITest.goodsList(1);
        // 校验列表商品名称、价格

    }

    /**
     * 校验第二页数据加载
     */
    public static void assertListNextPageItem() {
        JSONObject listJson = APIForUITest.goodsList(2);
        // 校验第二页的数据是否存在
    }

    /**
     * 验证列表已无更多数据
     */
    public static void assertNoMore(){
        objectNoMore();
    }

    /**
     * 滑动列表到底部
     */
    public static void actionScrollToListBottom() {
        Operate.flingToListEnd(objectList(),20);
    }

    /**
     * 双列banner 第一个位置跳转
     */
    public static void actionBanner2_1() {
        Operate.click(new UiObjectNew().findObjectNew(Config.TYPE_ID,BANNER_1_ID));
    }

    /**
     * 双列banner 第二个位置跳转
     */
    public static void actionBanner2_2() {
        Operate.click(new UiObjectNew().findObjectNew(Config.TYPE_ID,BANNER_2_ID));
    }
}
