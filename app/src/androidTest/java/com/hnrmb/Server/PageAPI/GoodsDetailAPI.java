package com.hnrmb.Server.PageAPI;

import com.alibaba.fastjson.JSONObject;
import com.hnrmb.Server.APIForUITest;

public class GoodsDetailAPI {

    /**
     * 通过接口获取商品信息
     */
    public static JSONObject getItemData(int id){
        return APIForUITest.goodsDetail(id);
    }

}
