package com.hnrmb.Page;

import androidx.test.uiautomator.UiObject;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.DataInfo;
import com.hnrmb.Utils.FailedCase;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.UiObjectNew;

/**
 * 好物 商品详情页面元素及操作封装
 *  * 规范：
 *  * 1、元素定位，以object开头
 *  * 2、操作，以action开头
 *  * 3、验证，以assert开头
 */

public class GoodsDetail {

    public static final String BUY_BTN_ID = "com.hnrmb.salary:id/tv_buy";
    // android.webkit.WebView

    // 购买按钮对象定位
    public static UiObject objectBuy(){
        return new UiObjectNew().findObjectNew(Config.TYPE_ID,BUY_BTN_ID);
    }

    /**
     * 获取购买按钮文案
     * @return
     */
    private static String getObjectBuyText(){
        return Operate.getText(objectBuy());
    }

    /**
     * 验证商品是否在售
     */
    public static void assertOnSale(){
        if (!getObjectBuyText().equals("立即购买")) FailedCase.interruptProcess("match wrong status", DataInfo.getDayFormatForIMG());
    }

    /**
     * 验证商品是否售罄
     */
    public static void assertOffSale(){
        if (!getObjectBuyText().equals("已售罄")) FailedCase.interruptProcess("match wrong status", DataInfo.getDayFormatForIMG());
    }

    // 点击购买按钮
    public static void actionBuy(){
        Operate.click(objectBuy());
    }

}
