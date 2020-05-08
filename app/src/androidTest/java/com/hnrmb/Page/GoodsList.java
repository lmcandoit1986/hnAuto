package com.hnrmb.Page;

import android.graphics.Path;

import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hnrmb.Config.Config;
import com.hnrmb.Server.APIForUITest;
import com.hnrmb.Utils.ObjectDec;
import com.hnrmb.Utils.ParseAnnotation;
import com.hnrmb.Utils.Solo;
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
    private Solo solo;
    public UiObjectNew UN;
    public GoodsList(Solo ob){
        solo = ob;
        UN = UiObjectNew.getInstance(solo);
    }

    public final String LIST_VIEW_ID = "com.hnrmb.salary:id/xrecycler_home"; // 好物列表整体
    public final String BANNER_1_ID = "com.hnrmb.salary:id/sdv_life_img_one"; // 双列 Banner 1位置
    public final String BANNER_2_ID = "com.hnrmb.salary:id/sdv_life_img_two"; // 双列 Banner 2位置
    public final String NAME_ID = "com.hnrmb.salary:id/tv_name";
    public final String PRICE_ID = "com.hnrmb.salary:id/tv_cost";
    public final String NO_MORE_TEXT = "美好生活 云成相伴";
    public final String BANNER_CHANGE_ICON_ID = "com.hnrmb.salary:id/banner_indicatorId";
    public final String BANNER_ID = "com.hnrmb.salary:id/banner";

    /**
     * 定位列表中的商品，通过文本定位
     * @param text
     * @return
     */
    private UiObject objectItemInList(String text){
        return UN.findObjectInListView(Config.TYPE_ID,LIST_VIEW_ID,text);
    }

    // 获取我的入口对象
    private UiObject objectOrderEntry(){
        return UN.findObjectNew(Config.TYPE_TEXT,"我的");
    }

//    @ObjectDec(type = Config.TYPE_TEXT,value = "我的",instance = 0)
//    public UiObject objectll;
//
//    public void actionTest(){
//        ParseAnnotation.parseMethod(GoodsList.class);
//        Operate.click(objectll);
//    }

    private UiObject objectItemBannerChangeIcon(int instance){
        try {
            return UN.findObjectNew(Config.TYPE_ID,BANNER_CHANGE_ICON_ID).getChild(new UiSelector().className("android.widget.ImageView").index(instance));
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 获取商品列表对象
    private UiScrollable objectList(){
        return UN.findListViewObject(Config.TYPE_ID,LIST_VIEW_ID);
    }

    // 获取列表底部没有更多的对象
    private UiObject objectNoMore(){
        return UN.findObjectNew(Config.TYPE_TEXT,NO_MORE_TEXT);
    }

    // 获取商品列表中的在售的商品信息
    public JSONObject getGoodsOnSale(){
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
    public JSONObject getGoodsOffSale(){
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
    public JSONObject getGoodsMinIsNotEqualMax(){
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
    public JSONObject getGoodsMinIsEqualMax(){
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
    public GoodsDetail actionItem(String text){
        Operate.click(objectItemInList(text));
        return new GoodsDetail(solo);
    }

    /**
     * 列表点击商品跳转到商品详情
     * @param text
     */
    public GoodsDetail actionItemOnCurrentShow(String text){
        Operate.click(UN.findObjectNew(Config.TYPE_TEXT,text));
        return new GoodsDetail(solo);
    }

    /**
     * 下拉刷新
     */
    public GoodsList actionLoadAgain(){
        Operate.swipe(Solo.getInstance().getMydevice(),Config.DOWN,5);
        return this;
    }

    /**
     * 切换到我的tab
     */
    public MyGoodsOrder actionOrder(){
        Operate.click(objectOrderEntry());
        return new MyGoodsOrder(solo);
    }

    /**
     * 校验列表元素
     */
    public GoodsList assertListItem() {
        JSONObject listJson = APIForUITest.goodsList(1);
        LogInfo.i(listJson.toString());
        // 校验列表商品名称、价格
        for(int j=0;j<(listJson.getJSONArray("data")).size();j++){
            JSONObject good = listJson.getJSONArray("data").getJSONObject(j);
            String Name = good.getString("name");
            objectItemInList(Name);
        }
        return this;

    }

    /**
     * 校验第二页数据加载
     */
    public GoodsList assertListNextPageItem() {
        JSONObject listJson = APIForUITest.goodsList(2);
        // 校验第二页的数据是否存在,只检查其中一个数据
        JSONObject good = listJson.getJSONArray("data").getJSONObject(1);
        String Name = good.getString("name");
        objectItemInList(Name);
        return this;
    }

    /**
     * banner
     */
    public JSONObject getBannerJsonData(int id){
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
     * banner
     */
    public JSONObject getBannerListJsonData(int id){
        JSONObject all = APIForUITest.GoodsBanner();
        JSONArray ja = all.getJSONObject("data").getJSONArray("bannerAds");
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
    public GoodsList assertNoMore(){
        objectNoMore();
        return this;
    }

    /**
     * 滑动列表到底部
     */
    public GoodsList actionScrollToListBottom() {
        Operate.flingForwardUtilExpectUI(objectList(),20,Config.TYPE_TEXT,NO_MORE_TEXT);
        return this;
    }

    /**
     * 滑动列表到指定位置
     */
    public GoodsList actionScrollToListExpectObject(String Value) {
        Operate.flingForwardUtilExpectUI(objectList(),20,Config.TYPE_TEXT,Value);
        return this;
    }

    /**
     * 滑动列表
     */
    public GoodsList actionScrollForward(int maxSwipes) {
        Operate.flingToListEnd(objectList(),maxSwipes);
        return this;
    }

    /**
     * 双列banner 第一个位置跳转
     */
    public GoodsList actionBanner2_1() {
        Operate.click(UN.findObjectNew(Config.TYPE_ID,BANNER_1_ID));
        return this;
    }

    /**
     * 双列banner 第二个位置跳转
     */
    public GoodsList actionBanner2_2() {
        Operate.click(UN.findObjectNew(Config.TYPE_ID,BANNER_2_ID));
        return this;
    }

    /**
     * 验证banner跳转
     * @return
     */
    public void assertBannerTurn(JSONObject item){
        if(item.getString("value").startsWith("hnczb:")){
            new GoodsDetail(solo).objectBuy();
        }else if (item.getString("value").startsWith("https")){
            new Webview(solo).assertIsWeb();
        }
    }

    /**
     * 轮播banner跳转
     */
    public void actionBanner(){
        Operate.click(UN.findObjectNew(Config.TYPE_ID,BANNER_ID));
    }

    /**
     * 轮播banner跳转
     */
    public void actionToExpectBanner(int instance){
        Operate.click(objectItemBannerChangeIcon(instance));
    }

    /**
     * 验证商品价格
     */
    public GoodsList assertPrice(JSONObject item){
        String min = String.valueOf(item.get("minPrice"));
        String max = String.valueOf(item.get("maxPrice"));
        String Price = null;
        if (min.equals(max) ){
            Price = String.format("¥ %s",min);
        }else{
            Price = String.format("¥ %s - %s",min,max);
        }
        UN.findObjectNew(Config.TYPE_TEXT,Price);
        return this;
    }


    // 用于简单监控
    public GoodsList assertNomal(){
        UN.findObjectNew(Config.TYPE_ID,NAME_ID);
        return this;
    }

    public GoodsDetail actionIntoDetailByInstance(int instance){
        Operate.clickAndWaitForNewWindow(UN.findObjectNew(Config.TYPE_ID,NAME_ID,instance));
        return new GoodsDetail(solo);
    }
}
