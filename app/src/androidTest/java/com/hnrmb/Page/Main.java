package com.hnrmb.Page;

import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import com.hnrmb.Config.Config;
import com.hnrmb.Data.User;
import com.hnrmb.Utils.Ele;
import com.hnrmb.Utils.LogInfo;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Selector;
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

    public Main(Solo so,String UserName,String Psw){
        solo = so;
        UN = UiObjectNew.getInstance(solo);
    }

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
    public final String tv_name_id = "com.hnrmb.salary:id/tv_name";

    private UiObject objectNavigation(int instance){
        return UN.findUiobject(Selector.resourceId(navigation_bar_id,instance));
    }

    private UiObject objectTV(String Name){
        return UN.findUiobject(Selector.text(Name).resourceId(tv_name_id),Selector.resourceId(ICON_ID));
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
         * 2 余额
         * 3 酒店（酒店预定）
         * 4 理财
         * 0 工资宝
         * 6 银行+
         * 5 投资圈
         * 8 好物
         * 7 公益
         * 1 每日签到
         */
        TimeAll.sleepTread(3000);
        while (true){
            Operate.clickAndWaitForNewWindow(UN.findUiobject(new Ele[]{new Ele(Config.TYPE_ID,ICON_ID,instance)}));
            TimeAll.sleepTread(1000);
            if(UN.findUiobject(new Ele[]{new Ele(Config.TYPE_TEXT,"投资圈")})==null){
                break;
            }
        }

//        Operate.clickAndWaitForNewWindow(UN.findObjectNew(Config.TYPE_ID,ICON_ID,instance));
    }

    private void actionIntoIV(String instance){
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
         * 2 余额
         * 3 酒店（酒店预定）
         * 4 理财
         * 0 工资宝
         * 6 银行+
         * 5 投资圈
         * 8 好物
         * 7 公益
         * 1 每日签到
         */
//        TimeAll.sleepTread(3000);
        while (true){
            LogInfo.i("点击 "+instance);
//            Operate.clickAndWaitForNewWindow(UN.findUiobject(new Ele[]{new Ele(Config.TYPE_ID,"com.hnrmb.salary:id/tv_name"),new Ele(Config.TYPE_TEXT,instance)},new Ele[]{new Ele(Config.TYPE_ID,"com.hnrmb.salary:id/iv_icon")}),30,5);
            Operate.clickAndWaitForNewWindow(objectTV(instance),30,5);

            TimeAll.sleepTread(1000);
            if(!UN.findUiobject(Selector.text("投资圈")).waitForExists(500)){
                break;
            }
            LogInfo.i("contiune");
        }

    }
    // 好物列表
    public GoodsList actionIntoGoodsList(){
        int instance = (Config.ENV.equals("rel"))?8:1 ;
        actionIntoIV("好物");
        return new GoodsList(solo);
    }
    // 理财列表
    public FIPList actionIntoFIPList(){
        int instance = (Config.ENV.equals("rel"))?4:2 ;
        actionIntoIV("理财");
        return new FIPList(solo);
    }
    // 银行+
    public BankList actionIntoBankList(){
        int instance = (Config.ENV.equals("rel"))?6:4 ;
        actionIntoIV("银行+");
        return new BankList(solo);
    }
    // 余额盈
    public Balance actionIntoBalanceIncoming(){
        int instance = (Config.ENV.equals("rel"))?2:0 ;
        actionIntoIV("余额盈");
        return new Balance(solo);
    }
    // 酒店
    public Hotel actionIntoHotel(){
        int instance = (Config.ENV.equals("rel"))?3:3 ;
        actionIntoIV("酒店");
        return new Hotel(solo);
    }

    // 公益
    public publicWork actionIntopublicWork(){
        int instance = (Config.ENV.equals("rel"))?7:5 ;
        actionIntoIV("公益");
        return new publicWork(solo);
    }

    // 工资宝
    public Pay actionIntoPay(){
        int instance = (Config.ENV.equals("rel"))?0:5 ;
        actionIntoIV("工资宝");
        return new Pay(solo);
    }






}
