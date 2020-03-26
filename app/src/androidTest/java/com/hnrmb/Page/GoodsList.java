package com.hnrmb.Page;

import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiScrollable;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hnrmb.Config.Config;
import com.hnrmb.Server.APIForUITest;
import com.hnrmb.Utils.DeviceInfo;
import com.hnrmb.Utils.FailedCase;
import com.hnrmb.Utils.LogInfo;
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
    public static final String NAME_ID = "com.hnrmb.salary:id/tv_name";
//    "com.hnrmb.salary:id/tv_cost"

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
    public static JSONObject getGoodsOnSale(){
        for(int i=1;i<10;i++){
            JSONObject listJson = APIForUITest.goodsList(i);
            // 判断商品是否在售
            for(int j=0;j<(listJson.getJSONArray("data")).size();j++){
                JSONObject good = listJson.getJSONArray("data").getJSONObject(j);
                if (good.getInteger("specialDisplay")==1){
                    return good;
                }
            }
        }
        FailedCase.interruptProcess("no good on sale");
        return null;

    }

    // 获取商品列表中售罄的商品信息
    public static JSONObject getGoodsOffSale(){
        for(int i=1;i<10;i++){
            JSONObject listJson = APIForUITest.goodsList(i);
            // 判断商品是否售罄
            for(int j=0;j<(listJson.getJSONArray("data")).size();j++){
                JSONObject good = listJson.getJSONArray("data").getJSONObject(j);
                if (good.getInteger("specialDisplay")==2){
                    return good;
                }
            }
        }
        FailedCase.interruptProcess("no good off sale");
        return null;

    }

    // 获取商品列表有价格区间的商品
    public static JSONObject getGoodsMinIsNotEqualMax(){
        for(int i=1;i<10;i++){
            JSONObject listJson = APIForUITest.goodsList(i);
            // 判断商品Min 和 Max 价格是否一致
            for(int j=0;j<(listJson.getJSONArray("data")).size();j++){
                JSONObject good = listJson.getJSONArray("data").getJSONObject(j);
                if (!good.get("minPrice").equals(good.get("maxPrice"))){
                    return good;
                }
            }
        }
        FailedCase.interruptProcess("no good mix != max price");
        return null;

    }

    // 获取商品列表中只有唯一价格的商品信息
    public static JSONObject getGoodsMinIsEqualMax(){
        for(int i=1;i<10;i++){
            JSONObject listJson = APIForUITest.goodsList(i);
            // 判断商品Min 和 Max 价格是否一致
            for(int j=0;j<(listJson.getJSONArray("data")).size();j++){
                JSONObject good = listJson.getJSONArray("data").getJSONObject(j);
                if (good.get("minPrice").equals(good.get("maxPrice"))){
                    return good;
                }
            }
        }
        FailedCase.interruptProcess("no good mix = max price");
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
     * 列表点击商品跳转到商品详情
     * @param text
     */
    public static void actionItemOnCurrentShow(String text){
        Operate.click(new UiObjectNew().findObjectNew(Config.TYPE_TEXT,text));
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
        for(int j=0;j<(listJson.getJSONArray("data")).size();j++){
            JSONObject good = listJson.getJSONArray("data").getJSONObject(j);
            String Name = good.getString("name");
            objectItemInList(Name);
        }

    }

    /**
     * 校验第二页数据加载
     */
    public static void assertListNextPageItem() {
        JSONObject listJson = APIForUITest.goodsList(2);
        // 校验第二页的数据是否存在,只检查其中一个数据
        JSONObject good = listJson.getJSONArray("data").getJSONObject(1);
        String Name = good.getString("name");
        objectItemInList(Name);
        return;
    }

    /**
     * banner
     */
    public static JSONObject getBannerJsonData(int id){
        JSONObject all = APIForUITest.GoodsBanner();
        JSONArray ja = all.getJSONObject("data").getJSONArray("imageFirstAds");
        for (int i=0;i<ja.size();i++){
            JSONObject item = ja.getJSONObject(i);
            if (item.getInteger("id")==id){
                return item;
            }
        }
        return null;
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
        Operate.flingForwardUtilExpectUI(objectList(),20,Config.TYPE_TEXT,"美好生活 云成相伴");
    }

    /**
     * 滑动列表到指定位置
     */
    public static void actionScrollToListExpectObject(String Value) {
        Operate.flingForwardUtilExpectUI(objectList(),20,Config.TYPE_TEXT,Value);
    }

    /**
     * 滑动列表
     */
    public static void actionScrollForward(int maxSwipes) {
        Operate.flingToListEnd(objectList(),maxSwipes);
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

    /**
     * 验证banner跳转
     * @return
     */
    public static void assertBannerTurn(JSONObject item){
        if(item.getString("value").startsWith("hnczb:")){
            GoodsDetail.objectBuy();
        }else if (item.getString("value").startsWith("https")){
            Webview.assertIsWeb();
        }
    }
}
