package com.hnrmb.Server;

import com.alibaba.fastjson.JSONObject;

public class APIForUITest {

    public static JSONObject HWList(){
        // 请求接口地址
        String Url = "";
        // 业务参数
        JSONObject body = new JSONObject();
        body.put("key","vaule");

        return Request.requestPost(Url,body.toString());
    }

}
