package com.hnrmb.Page;

import android.graphics.Path;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.TimeAll;
import com.hnrmb.Utils.UiObjectNew;

public class BuyFIP {
    public Solo solo;
    public UiObjectNew UN;
    public BuyFIP(Solo so) {
        solo = so;
        UN = UiObjectNew.getInstance(so);
    }

    public BuyFIP actionSetMoney(String money){
        for(int i=0;i<money.length();i++){
            Operate.click(UN.findObjectNew(Config.TYPE_TEXT, String.valueOf(money.charAt(i))));
        }
        return this;
    }

    public Webview actionIntoStaticWeb(){
        Operate.clickAndWaitForNewWindow(UN.findObjectWebView(Config.TYPE_TEXT,"转入"));
        return new Webview(solo);
    }

    public FIPDetail actionBack(){
        Operate.click(UN.findObjectNew(Config.TYPE_ID,"com.hnrmb.salary:id/ifv_left"));
        return new FIPDetail(solo);
    }

    public BuyFIP actionSure(){
        Operate.click(UN.findObjectWebView(Config.TYPE_TEXT,"确认购买"));
        return this;
    }

    public ResultFIP actionPsw(String psw){
        for(int i=0;i<psw.length();i++){
            Operate.click(UN.findObjectNew(Config.TYPE_TEXT, String.valueOf(psw.charAt(i))));
        }
        return new ResultFIP(solo);
    }



}
