package com.hnrmb.Page;

import android.graphics.Path;

import androidx.test.uiautomator.UiObject;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.DeviceInfo;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.UiObjectNew;

public class GoodsList {

    public static final String id_listview = "com.hnrmb.salary:id/xrecycler_home";

    /**
     * 元素定位，通过列表获取
     * @param text
     * @return
     */
    private static UiObject locationByTextInList(String text){
        return new UiObjectNew().findObjectInListView(Config.TYPE_ID,id_listview,text);
    }

    private static UiObject orderEntry(){
        return new UiObjectNew().findObjectNew(Config.TYPE_TEXT,"我的");
    }

    /**
     * 列表点击商品跳转到商品详情
     * @param text
     */
    public static void intentItemDetail(String text){
        Operate.click(locationByTextInList(text));
    }

    /**
     * 下拉刷新
     */
    public static void loadAgain(){
        Operate.swipe(DeviceInfo.getInstance().getMydevice(),Config.DOWN,5);
    }

    /**
     * 切换到我的tab
     */
    public static void intoOrderList(){
        Operate.click(orderEntry());
    }


}
