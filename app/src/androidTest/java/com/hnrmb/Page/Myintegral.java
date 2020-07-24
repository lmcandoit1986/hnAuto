package com.hnrmb.Page;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.LogInfo;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Selector;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.TimeAll;
import com.hnrmb.Utils.UiObjectNew;
/**
 * 我的积分页面元素及操作封装
 * 规范：
 * 1、元素定位，以object开头
 * 2、操作，以action开头
 * 3、验证，以assert开头
 */
public class Myintegral {

    private Solo solo;
    private UiObjectNew UN;
    public Myintegral(Solo so) {
        solo = so;
        UN = UiObjectNew.getInstance(solo);
    }

    public Myintegral assertNomal(){
        UN.findObjectNew(Config.TYPE_TEXT,"我的积分");
        // 顺带如果没有签到则签到
//        LogInfo.i(solo.getModule());
//        if (solo.getModule().trim().equals("Redmi Note 8 Pro")){
//            Operate.click(solo.getMydevice(),500,910);
//            TimeAll.sleepTread(1500);
//            return this;
//        }
        solo.setWaitForSelectorTimeout(3000);
        Operate.click(UN.findUiobject(Selector.textStartWith("签到")),false,5,0);
        TimeAll.sleepTread(3);
        solo.setWaitForSelectorTimeout(10000);
        return this;
    }
}
