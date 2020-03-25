package com.hnrmb.Server;

import com.alibaba.fastjson.JSONObject;

public class APIForUITest {

    /**
     * 列表请求
     * @param pageNum
     * @return
     */
    public static JSONObject goodsList(int pageNum){
        // 请求接口地址
        String Url = "";
        // 业务参数
        JSONObject body = new JSONObject();
        body.put("key","vaule");

        return Request.requestPost(Url,body.toString());
    }

    /**
     * 详情请求接口
     * @param id
     * @return
     */
    public static JSONObject goodsDetail(int id){
        String Url = "";
        // 业务参数
        JSONObject body = new JSONObject();
        body.put("key","vaule");

        return Request.requestPost(Url,body.toString());
    }

    /**
     * banner 请求接口
     * @return
     */
    public static JSONObject GoodsBanner(){
        String Url = "";
        // 业务参数
        JSONObject body = new JSONObject();
        body.put("key","vaule");

        return Request.requestPost(Url,body.toString());
    }

}
