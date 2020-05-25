package com.hnrmb.Page;

import androidx.test.uiautomator.UiObject;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.DataInfo;
import com.hnrmb.Utils.FailedCase;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;
/**
 * 酒店页面元素及操作封装
 * 规范：
 * 1、元素定位，以object开头
 * 2、操作，以action开头
 * 3、验证，以assert开头
 */
public class Hotel {
    public Solo solo;
    public UiObjectNew UN;
    public Hotel(Solo so) {
        solo = so;
        UN = UiObjectNew.getInstance(so);
    }

    public final String title_id = "com.hnrmb.salary:id/tv_title";

    public UiObject objectTitle(){
        return UN.findObjectNew(Config.TYPE_TEXT,"酒店预订",title_id);
    }

    public String getTitle(){
        return Operate.getText(objectTitle());
    }


    public Hotel assertNomal(){
        String title = getTitle();
        if (!title.equals("酒店预订"))
            FailedCase.interruptProcess(String.format("标题预期:酒店预订,实际:%s",title), DataInfo.getDayFormatForIMG());
        return this;
    }

}
