package com.hnrmb.Server;

import com.alibaba.fastjson.JSONObject;

public class APIForUITest {

    /**
     * 列表请求
     * @param pageNum
     * @return
     */
    public static JSONObject goodsList(int pageNum){
        /**
         * 请求接口地址 https://www.bjycjf.com/api2/goods/business?
         * {
         *    "data": [
         *      {
         *        "id": 137,
         *        "name": "按城市配送",
         *        "specialDisplay": 1,
         *        "poster": "https:\/\/qnstaticbeta.ycfin.com.cn\/15819973322581.png",
         *        "minPrice": "0.01",
         *        "maxPrice": "0.01"
         *      },
         *      {
         *        "id": 139,
         *        "name": "按城市配送3",
         *        "specialDisplay": 2,
         *        "poster": "https:\/\/qnstaticbeta.ycfin.com.cn\/15820070422581.png",
         *        "minPrice": "0.01",
         *        "maxPrice": "0.01"
         *     }
         *    ]
         *  }
         */

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
        /**
         * api：https://www.bjycjf.com/api2/goods/detail/137?
         * {
         *     "data": {
         *       "id": 137,
         *       "type": 1,
         *       "name": "按城市配送",
         *       "introduction": "按城市配送",
         *       "statusTip": "立即购买",
         *       "status": 1,
         *       "poster": "https:\/\/qnstaticbeta.ycfin.com.cn\/15819973356501.png",
         *       "minPrice": 0.01,
         *       "maxPrice": 0.01,
         *       "description": "<link rel=\"stylesheet\" href=\"https:\/\/static.hnczb.com\/static\/app-webview\/assets\/css\/crowdfunding.css?0.3811634165534752\"><style>*{margin:0;padding:0;}p{padding: 0;margin: 0;text-align:justify;margin: 0;padding: 0;font-family: Arial,\"微软雅黑\";font-size:.75rem;}img{max-width:100%;margin:5px 0;display:block;}<\/style><p><img alt=\"1.png\" src=\"https:\/\/qnstaticbeta.ycfin.com.cn\/15819973260341.png\" \/><br><\/p>",
         *       "merchant": {
         *         "name": "北京本来工坊科技有限公司",
         *         "address": "北京市朝阳区住邦2000商务中心1号楼B座15层",
         *        "phone": "4006917917",
         *         "brandName": "测试-本来生活",
         *        "logo": "https:\/\/qnstaticbeta.ycfin.com.cn\/1581390058692WechatIMG669_gaitubao_96x96.jpg"
         *       },
         *       "specs": [
         *        {
         *           "id": 285,
         *           "statusTips": "立即购买",
         *           "status": 1,
         *           "price": 0.01,
         *           "name": "回报1",
         *           "introduction": "按城市配送",
         *           "poster": "https:\/\/qnstaticbeta.ycfin.com.cn\/15819973452621.png",
         *           "deliverMethod": "配送：免运费",
         *           "stock": 979,
         *           "selfLimit": 1000
         *         }
         *       ]
         *     }
         *   }
         */
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
