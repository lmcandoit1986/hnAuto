package com.hnrmb.Page;

import androidx.test.uiautomator.UiObject;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;
/**
 * 好物购买流程涉及页面页面元素及操作封装
 * 规范：
 * 1、元素定位，以object开头
 * 2、操作，以action开头
 * 3、验证，以assert开头
 */
public class Buy {

    public final String SKU_ID = "com.hnrmb.salary:id/to_range_lay";// 选择规格

    public Solo solo;
    public UiObjectNew UN;
    public Buy(Solo so) {
        solo = so;
        UN = UiObjectNew.getInstance(solo);
    }

    // 选择规格对象定位
    private UiObject objectSKU(){
        return UN.findObjectNew(Config.TYPE_ID,SKU_ID);
    }

    // 点击选择规格
    public Buy actionSKU(){
        Operate.click(objectSKU());
        return this;
    }
}
