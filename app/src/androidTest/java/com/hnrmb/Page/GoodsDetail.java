package com.hnrmb.Page;

import androidx.test.uiautomator.UiObject;

import com.alibaba.fastjson.JSONObject;
import com.hnrmb.Config.Config;
import com.hnrmb.Server.APIForUITest;
import com.hnrmb.Utils.DataInfo;
import com.hnrmb.Utils.FailedCase;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.UiObjectNew;

/**
 * 好物 商品详情页面元素及操作封装
 *  * 规范：
 *  * 1、元素定位，以object开头
 *  * 2、操作，以action开头
 *  * 3、验证，以assert开头
 */

public class GoodsDetail {

    public static final String BUY_BTN_ID = "com.hnrmb.salary:id/tv_buy";// 购买按钮
    public static final String NAME_ID = "com.hnrmb.salary:id/life_product_name_tv";// 商品名称
    public static final String DESC_ID = "com.hnrmb.salary:id/life_product_introduction_tv";// 商品描述
    public static final String PRICE_ID = "com.hnrmb.salary:id/price_range_tv";// 商品价格
    public static final String SKU_ID = "com.hnrmb.salary:id/to_range_lay";// 选择规格
    // android.webkit.WebView

    // 购买按钮对象定位
    public static UiObject objectBuy(){
        return new UiObjectNew().findObjectNew(Config.TYPE_ID,BUY_BTN_ID);
    }

    // 商品名称对象定位
    public static UiObject objectName(){
        return new UiObjectNew().findObjectNew(Config.TYPE_ID,NAME_ID);
    }

    // 商品描述对象定位
    public static UiObject objectDesc(){
        return new UiObjectNew().findObjectNew(Config.TYPE_ID,DESC_ID);
    }

    // 商品加个对象定位
    public static UiObject objectPrice(){
        return new UiObjectNew().findObjectNew(Config.TYPE_ID,PRICE_ID);
    }

    // 选择规格对象定位
    public static UiObject objectSKU(){
        return new UiObjectNew().findObjectNew(Config.TYPE_ID,SKU_ID);
    }

    /**
     * 获取购买按钮文案
     * @return
     */
    private static String getObjectBuyText(){
        return Operate.getText(objectBuy());
    }

    /**
     * 获取商品名称文案
     * @return
     */
    private static String getObjectName(){
        return Operate.getText(objectName());
    }

    /**
     * 获取商品描述文案
     * @return
     */
    private static String getObjectDesc(){
        return Operate.getText(objectDesc());
    }

    /**
     * 获取商品价格文案
     * @return
     */
    private static String getObjectPrice(){
        return Operate.getText(objectPrice());
    }

    /**
     * 通过接口获取商品信息
     */
    public static JSONObject getItemData(int id){
        return APIForUITest.goodsDetail(id);
    }

    /**
     * 验证商品是否在售
     */
    public static void assertOnSale(){
        if (!getObjectBuyText().equals("立即购买")) FailedCase.interruptProcess("match wrong status", DataInfo.getDayFormatForIMG());
    }

    /**
     * 验证商品是否售罄
     */
    public static void assertOffSale(){
        if (!getObjectBuyText().equals("已售罄")) FailedCase.interruptProcess("match wrong status", DataInfo.getDayFormatForIMG());
    }

    /**
     * 验证商品名称
     */
    public static void assertName(int id){
        JSONObject jsonObject = getItemData(id);
        String Name = jsonObject.getJSONObject("data").getString("name");
        if (!getObjectName().equals(Name)) FailedCase.interruptProcess("Name match wrong ,expect:"+Name, DataInfo.getDayFormatForIMG());
    }

    /**
     * 验证商品描述
     */
    public static void assertDesc(int id){
        JSONObject jsonObject = getItemData(id);
        String Desc = jsonObject.getJSONObject("data").getString("introduction");
        if (!getObjectDesc().equals(Desc)) FailedCase.interruptProcess("Desc match wrong ,expect:"+Desc, DataInfo.getDayFormatForIMG());
    }

    /**
     * 验证商品价格
     */
    public static void assertPrice(int id){
        JSONObject jsonObject = getItemData(id);
        String min = String.valueOf(jsonObject.getJSONObject("data").get("minPrice"));
        String max = String.valueOf(jsonObject.getJSONObject("data").get("maxPrice"));
        String Price = null;
        if (min.equals(max) ){
            Price = String.format("¥ %s",min);
        }else{
            Price = String.format("¥ %s - %s",min,max);
        }
        if (!getObjectPrice().equals(Price)) FailedCase.interruptProcess("Price match wrong,expect :"+Price, DataInfo.getDayFormatForIMG());
    }

    // 点击购买按钮
    public static void actionBuy(){
        Operate.click(objectBuy());
    }

    // 点击选择规格
    public static void actionSKU(){
        Operate.click(objectSKU());
    }

}
