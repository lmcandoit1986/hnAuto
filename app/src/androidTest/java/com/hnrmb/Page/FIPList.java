package com.hnrmb.Page;

import androidx.test.uiautomator.UiObject;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.DataInfo;
import com.hnrmb.Utils.Ele;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.TimeAll;
import com.hnrmb.Utils.UiObjectNew;
/**
 * 理财列表页面元素及操作封装
 * 规范：
 * 1、元素定位，以object开头
 * 2、操作，以action开头
 * 3、验证，以assert开头
 */
public class FIPList {

    private final String list_id = "com.hnrmb.salary:id/xrecycler_financing";
    private final String item_id = "com.hnrmb.salary:id/lay_financing";
    private final String name_id = "com.hnrmb.salary:id/tv_name"; // 产品名称
    private final String tag_id = "com.hnrmb.salary:id/tv_tag"; // 产品标签：热卖、售罄
    private final String rate_id = "com.hnrmb.salary:id/tv_one_data"; // 产品 利率
    private final String date_id = "com.hnrmb.salary:id/tv_two_data"; // 产品 期限
    private final String min_money_id = "com.hnrmb.salary:id/tv_two_title"; // 产品 最低起售

    public Solo solo;
    public UiObjectNew UN;
    public FIPList(Solo so) {
        solo = so;
        UN = UiObjectNew.getInstance(solo);

    }

    public UiObject objectFIPInList(String FIPName){
        return UN.findObjectInListView(Config.TYPE_ID,list_id,Config.TYPE_ID,name_id,FIPName);
    }

    public FIPDetail actionIntoFIPDetail(String FIPName){
        Operate.click(objectFIPInList(FIPName));
        return new FIPDetail(solo,FIPName);
    }



    // 用于监控
    public FIPList assertNomal(){
        UN.findObjectNew(Config.TYPE_ID,name_id);
        UN.findObjectNew(Config.TYPE_ID,rate_id);
        UN.findObjectNew(Config.TYPE_ID,date_id);
        UN.findObjectNew(Config.TYPE_ID,min_money_id);
        return this;
    }

    public FIPDetail actionIntoFIPDetail(int instance){
        UiObject fip  = UN.findObjectNew(Config.TYPE_ID,name_id,instance);
        String fipName = Operate.getText(fip);
        Operate.clickAndWaitForNewWindow(fip);
        return new FIPDetail(solo,fipName);
    }




}
