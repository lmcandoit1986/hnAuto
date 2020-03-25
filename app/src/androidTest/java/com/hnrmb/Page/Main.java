package com.hnrmb.Page;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.UiObjectNew;

/**
 * 主页面元素及操作封装
 * 规范：
 * 1、元素定位，以object开头
 * 2、操作，以action开头
 * 3、验证，以assert开头
 */
public class Main {

    // com.hnrmb.salary:id/tv_update
    // com.hnrmb.salary:id/linear_close 关闭
    // com.hnrmb.salary:id/iv_toolbar_back
    // com.hnrmb.salary:id/sdv_life_img_one
    // com.hnrmb.salary:id/sdv_life_img_two
    // com.hnrmb.salary:id/xrecycler_home
    public static final String ICON_ID = "com.hnrmb.salary:id/iv_icon";// 5列 推广入口


    public static void actionIntoIV(int instance){
        /**
         * 0 余额盈
         * 1 投资圈
         * 2 理财
         * 3 酒店
         * 4 银行+
         * 5 公益
         * 6 保险
         * 7 哆啦A梦
         * 8 好物
         * 9
         */
        Operate.click(new UiObjectNew().findObjectNew(Config.TYPE_ID,ICON_ID,instance));
    }



}
