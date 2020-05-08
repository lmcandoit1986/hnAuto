package com.hnrmb.Server.PageAPI;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hnrmb.Server.APIForUITest;
import com.hnrmb.Utils.FailedCase;

public class GoodsListAPI {

    /**
     * banner
     */
    public static JSONObject getBannerListJsonData(int id){
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

}
