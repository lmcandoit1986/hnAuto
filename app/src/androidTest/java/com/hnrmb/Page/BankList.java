package com.hnrmb.Page;

import android.graphics.Path;

import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiSelector;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.DataInfo;
import com.hnrmb.Utils.Ele;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.TimeAll;
import com.hnrmb.Utils.UiObjectNew;
/**
 * 银行+页面元素及操作封装
 * 规范：
 * 1、元素定位，以object开头
 * 2、操作，以action开头
 * 3、验证，以assert开头
 */
public class BankList {

    public Solo solo;
    public UiObjectNew UN;
    public BankList(Solo so) {
        solo = so;
        UN = UiObjectNew.getInstance(solo);
        long End = DataInfo.getTime()+ 3 * 60;
        UiObject banner = UN.findUiobject(new Ele[]{new Ele(Config.TYPE_TEXT,"banner.png")});
        while (true){
            if (Operate.assertWaitForExists(banner,15)){
                break;
            }
            if (DataInfo.getTime() >= End){
                break;
            }
        }

    }

    public BankList assertNomal(){
        UN.findUiobject(new Ele[]{new Ele(Config.TYPE_TEXT,"市场")});
        return this;
    }

    public BankProduct actionIntoDetail(String PName){
//        TimeAll.sleepTread(1000);
        Operate.clickAndWaitForNewWindow(UN.findUiobject(new Ele[]{new Ele(Config.TYPE_TEXT,PName)}));
        return new BankProduct(solo,PName);
    }

    public BankProduct actionINtoDetail(int instance){
        UiObject item = UN.findUiobject(new Ele[]{new Ele(Config.TYPE_TEXT_1,0,".*银行$",instance)},new Ele[]{new Ele(2)});
        String title = Operate.getText(item);
        Operate.clickAndWaitForNewWindow(item);
        return new BankProduct(solo,title);
    }

}
