package com.hnrmb.Page;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Solo;
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
        UN.findObjectNew(Config.TYPE_TEXT,"中奖记录");
        // 顺带如果没有签到则签到
        solo.setWaitForSelectorTimeout(3000);
        Operate.click(UN.findObjectNew(Config.TYPE_TEXT,"签到",false),false);
        solo.setWaitForSelectorTimeout(10000);
        return this;
    }
}
