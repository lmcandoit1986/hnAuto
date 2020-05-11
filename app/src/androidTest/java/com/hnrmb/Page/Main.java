package com.hnrmb.Page;

import androidx.test.uiautomator.UiObject;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.TimeAll;
import com.hnrmb.Utils.UiObjectNew;

/**
 * 主页面元素及操作封装
 * 规范：
 * 1、元素定位，以object开头
 * 2、操作，以action开头
 * 3、验证，以assert开头
 */
public class Main {

    public Solo solo;
    public UiObjectNew UN;
    public Main(Solo so){
        solo = so;
        UN = UiObjectNew.getInstance(solo);
    }

    // com.hnrmb.salary:id/tv_update
    // com.hnrmb.salary:id/linear_close 关闭
    // com.hnrmb.salary:id/iv_toolbar_back
    // com.hnrmb.salary:id/sdv_life_img_one
    // com.hnrmb.salary:id/sdv_life_img_two
    // com.hnrmb.salary:id/xrecycler_home
    public final String ICON_ID = "com.hnrmb.salary:id/iv_icon";// 5列 推广入口
    public final String navigation_bar_id = "com.hnrmb.salary:id/eiv_type";

    private UiObject objectNavigation(int instance){
        return UN.findObjectNew(Config.TYPE_ID,navigation_bar_id,instance);
    }

    public My actionIntoMy(){
        TimeAll.sleepTread(3000);
        Operate.click(objectNavigation(2));
        return new My(solo);
    }


    private void actionIntoIV(int instance){
        /**
         * 测试环境
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
         * 线上
         * 0 余额
         * 1 酒店（酒店预定）
         * 2 理财
         * 3 投资圈
         * 4 银行+
         * 5 公益（扶贫公益）
         * 6 好物
         * 7 敬请期待
         * 8 每日签到
         */
        TimeAll.sleepTread(3000);
        Operate.clickAndWaitForNewWindow(UN.findObjectNew(Config.TYPE_ID,ICON_ID,instance));
    }
    // 好物列表
    public GoodsList actionIntoGoodsList(){
        int instance = (Config.ENV.equals("rel"))?6:8 ;
        actionIntoIV(instance);
        return new GoodsList(solo);
    }
    // 理财列表
    public FIPList actionIntoFIPList(){
        int instance = (Config.ENV.equals("rel"))?2:2 ;
        actionIntoIV(instance);
        return new FIPList(solo);
    }
    // 银行+
    public BankList actionIntoBankList(){
        int instance = (Config.ENV.equals("rel"))?4:4 ;
        actionIntoIV(instance);
        return new BankList(solo);
    }
    // 余额盈
    public Balance actionIntoBalanceIncoming(){
        int instance = (Config.ENV.equals("rel"))?0:0 ;
        actionIntoIV(instance);
        return new Balance(solo);
    }
    // 酒店
    public Hotel actionIntoHotel(){
        int instance = (Config.ENV.equals("rel"))?1:3 ;
        actionIntoIV(instance);
        return new Hotel(solo);
    }

    // 公益
    public publicWork actionIntopublicWork(){
        int instance = (Config.ENV.equals("rel"))?5:5 ;
        actionIntoIV(instance);
        return new publicWork(solo);
    }






}
