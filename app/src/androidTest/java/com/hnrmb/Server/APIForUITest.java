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
        // https://www.bjycjf.com/api2/goods/detail/137?
        /**
         * 2020-03-25 19:18:34.214 25038-25038/? D/PRETTY_LOGGER: │ {
         * 2020-03-25 19:18:34.214 25038-25038/? D/PRETTY_LOGGER: │   "data": {
         * 2020-03-25 19:18:34.214 25038-25038/? D/PRETTY_LOGGER: │     "id": 137,
         * 2020-03-25 19:18:34.214 25038-25038/? D/PRETTY_LOGGER: │     "type": 1,
         * 2020-03-25 19:18:34.214 25038-25038/? D/PRETTY_LOGGER: │     "name": "按城市配送",
         * 2020-03-25 19:18:34.214 25038-25038/? D/PRETTY_LOGGER: │     "introduction": "按城市配送",
         * 2020-03-25 19:18:34.214 25038-25038/? D/PRETTY_LOGGER: │     "statusTip": "立即购买",
         * 2020-03-25 19:18:34.214 25038-25038/? D/PRETTY_LOGGER: │     "status": 1,
         * 2020-03-25 19:18:34.214 25038-25038/? D/PRETTY_LOGGER: │     "poster": "https:\/\/qnstaticbeta.ycfin.com.cn\/15819973356501.png",
         * 2020-03-25 19:18:34.214 25038-25038/? D/PRETTY_LOGGER: │     "minPrice": 0.01,
         * 2020-03-25 19:18:34.214 25038-25038/? D/PRETTY_LOGGER: │     "maxPrice": 0.01,
         * 2020-03-25 19:18:34.214 25038-25038/? D/PRETTY_LOGGER: │     "description": "<link rel=\"stylesheet\" href=\"https:\/\/static.hnczb.com\/static\/app-webview\/assets\/css\/crowdfunding.css?0.3811634165534752\"><style>*{margin:0;padding:0;}p{padding: 0;margin: 0;text-align:justify;margin: 0;padding: 0;font-family: Arial,\"微软雅黑\";font-size:.75rem;}img{max-width:100%;margin:5px 0;display:block;}<\/style><p><img alt=\"1.png\" src=\"https:\/\/qnstaticbeta.ycfin.com.cn\/15819973260341.png\" \/><br><\/p>",
         * 2020-03-25 19:18:34.214 25038-25038/? D/PRETTY_LOGGER: │     "merchant": {
         * 2020-03-25 19:18:34.214 25038-25038/? D/PRETTY_LOGGER: │       "name": "北京本来工坊科技有限公司",
         * 2020-03-25 19:18:34.214 25038-25038/? D/PRETTY_LOGGER: │       "address": "北京市朝阳区住邦2000商务中心1号楼B座15层",
         * 2020-03-25 19:18:34.214 25038-25038/? D/PRETTY_LOGGER: │       "phone": "4006917917",
         * 2020-03-25 19:18:34.214 25038-25038/? D/PRETTY_LOGGER: │       "brandName": "测试-本来生活",
         * 2020-03-25 19:18:34.214 25038-25038/? D/PRETTY_LOGGER: │       "logo": "https:\/\/qnstaticbeta.ycfin.com.cn\/1581390058692WechatIMG669_gaitubao_96x96.jpg"
         * 2020-03-25 19:18:34.215 25038-25038/? D/PRETTY_LOGGER: │     },
         * 2020-03-25 19:18:34.215 25038-25038/? D/PRETTY_LOGGER: │     "specs": [
         * 2020-03-25 19:18:34.215 25038-25038/? D/PRETTY_LOGGER: │       {
         * 2020-03-25 19:18:34.215 25038-25038/? D/PRETTY_LOGGER: │         "id": 285,
         * 2020-03-25 19:18:34.215 25038-25038/? D/PRETTY_LOGGER: │         "statusTips": "立即购买",
         * 2020-03-25 19:18:34.217 25038-25038/? D/PRETTY_LOGGER: │         "status": 1,
         * 2020-03-25 19:18:34.217 25038-25038/? D/PRETTY_LOGGER: │         "price": 0.01,
         * 2020-03-25 19:18:34.217 25038-25038/? D/PRETTY_LOGGER: │         "name": "回报1",
         * 2020-03-25 19:18:34.217 25038-25038/? D/PRETTY_LOGGER: │         "introduction": "按城市配送",
         * 2020-03-25 19:18:34.217 25038-25038/? D/PRETTY_LOGGER: │         "poster": "https:\/\/qnstaticbeta.ycfin.com.cn\/15819973452621.png",
         * 2020-03-25 19:18:34.217 25038-25038/? D/PRETTY_LOGGER: │         "deliverMethod": "配送：免运费",
         * 2020-03-25 19:18:34.217 25038-25038/? D/PRETTY_LOGGER: │         "stock": 979,
         * 2020-03-25 19:18:34.217 25038-25038/? D/PRETTY_LOGGER: │         "selfLimit": 1000
         * 2020-03-25 19:18:34.218 25038-25038/? D/PRETTY_LOGGER: │       }
         * 2020-03-25 19:18:34.218 25038-25038/? D/PRETTY_LOGGER: │     ]
         * 2020-03-25 19:18:34.218 25038-25038/? D/PRETTY_LOGGER: │   }
         * 2020-03-25 19:18:34.218 25038-25038/? D/PRETTY_LOGGER: │ }
         * 2020-03-25 19:18:34.218 25038-25038/? D/PRETTY_LOGGER: └────────────────────────────────────────────────────────────────────────────────────────────────────────────────
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
