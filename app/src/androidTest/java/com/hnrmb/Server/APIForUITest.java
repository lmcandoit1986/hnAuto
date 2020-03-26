package com.hnrmb.Server;

import com.alibaba.fastjson.JSONObject;

public class APIForUITest {

    public static final String COOKIE = "XDevice=cbea71d8638e0cf4eb1352e34828093e; XToken=669a133d-1f6e-4b3b-9cfc-89c6c461b6a9; SESSION=669a133d-1f6e-4b3b-9cfc-89c6c461b6a9; gaOpenId=GA201909261721261038397092; _UNAME=%E4%B8%80%E9%9B%B6%E4%BA%8C";

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

        String Url = "https://www.bjycjf.com/api2/goods/business?page="+pageNum+"&size=10";
        // 业务参数
        // JSONObject body = new JSONObject();
        // body.put("key","vaule");
        // return Request.requestPost(Url,body.toString());
        return Request.requestGet(Url,COOKIE);
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
        String Url = "https://www.bjycjf.com/api2/goods/detail/"+id;
        // 业务参数
//        JSONObject body = new JSONObject();
//        body.put("key","vaule");

//        return Request.requestPost(Url,body.toString());
        return Request.requestGet(Url,COOKIE);
    }


    /**
     * banner 请求接口
     * @return
     */
    public static JSONObject GoodsBanner(){
        /**
         * {
         * 	"data": {
         * 		"imageFirstAds": [{
         * 			"image": "https://qnstaticbeta.ycfin.com.cn/15717286886861F2.png",
         * 			"action": "url",
         * 			"id": 1,
         * 			"text": "更新位置 1 的 Banner",
         * 			"value": "https://www.bjycjf.com/static/app-webview/dist/page/life/project.html?id=16",
         * 			"md5": "EC380480AF2951B66507574BAF2875B1"
         *                }, {
         * 			"image": "https://qnstaticbeta.ycfin.com.cn/15717287397202F2.png",
         * 			"action": "embed",
         * 			"id": 2,
         * 			"text": "新增位置 2 的 Banner",
         * 			"value": "hnczb://native?url=l_d&id=91",
         * 			"md5": "56CC08979F1C992EC51597A3F6731C84"
         *        }],
         * 		"imageSecondAds": [],
         * 		"bannerAds": [{
         * 			"image": "https://qnstaticbeta.ycfin.com.cn/1571649165360Banner1.png",
         * 			"action": "url",
         * 			"end": 1918718371000,
         * 			"id": 1,
         * 			"text": "新增位置 1 的 Banner",
         * 			"begin": 1568970808000,
         * 			"value": "https://www.bjycjf.com/static/app-webview/dist/page/life/project.html?id=17",
         * 			"md5": "464929EB9E1A77BC3DAA0212A8F00915"
         *        }, {
         * 			"image": "https://qnstaticbeta.ycfin.com.cn/1571649241527Banner2.png",
         * 			"action": "url",
         * 			"end": 1918718371000,
         * 			"id": 2,
         * 			"text": "新增位置 2 的 Banner",
         * 			"begin": 1571649290000,
         * 			"value": "https://www.bjycjf.com/static/app-webview/dist/page/life/project.html?id=3",
         * 			"md5": "42BF81AF8D4C06A3886B674E9AD79B31"
         *        }, {
         * 			"image": "https://qnstaticbeta.ycfin.com.cn/1571649402381Banner3.png",
         * 			"action": "embed",
         * 			"end": 1918718371000,
         * 			"id": 3,
         * 			"text": "新增位置 3 的 Banner",
         * 			"begin": 1571563046000,
         * 			"value": "hnczb://native?url=l_d&id=108",
         * 			"md5": "3389E242D8353DDB1F144A83D634B1E7"
         *        }]* 	}
         * }
         */
        String Url = "https://www.bjycjf.com/api2/goods/operation";
        // 业务参数
//        JSONObject body = new JSONObject();
//        body.put("key","vaule");
//
//        return Request.requestPost(Url,body.toString());
        return Request.requestGet(Url,COOKIE);
    }

}
