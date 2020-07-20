package com.hnrmb.Page;

import androidx.test.uiautomator.UiObject;

import com.hnrmb.Utils.DataInfo;
import com.hnrmb.Utils.LogInfo;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Selector;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;

public class BuyRyb {

    public Solo solo;
    public UiObjectNew UN;
    public BuyRyb(Solo so) {
        solo = so;
        UN = UiObjectNew.getInstance(so);
        long end = DataInfo.getTime() +5;
        while (true){
            if (Operate.assertWaitForExists(objectTitle("购买"),5)){
                break;
            }
            if(DataInfo.getTime() > end){
                LogInfo.w("超5秒，页面加载未完成");
                break;
            }
        }
    }

    private UiObject objectTitle(String Name){
        return UN.findUiobject(Selector.resourceId("com.hnrmb.salary:id/head_content_tv").text(Name));
    }

    public int MSAccount(){
        UiObject account = UN.findUiobject(Selector.text("账户余额"),Selector.index(1));
        int Money = Integer.getInteger(Operate.getText(account));
        return Money;
    }

    public BuyRyb actionSetMoney(String Money){
        // 注意前2位不能一样，例如不能买11，可以121
        for(int i=0;i<Money.length();i++){
            Operate.click(UN.findUiobject(Selector.text(String.valueOf(Money.charAt(i)))));
        }
        return this;
    }

    public PassWord actionSureSuccess(){
        Operate.click(UN.findUiobject(Selector.className("android.widget.Button").text("确认购买")));
        return new PassWord(solo);
    }

    public BuyRyb actionSureWithExcept(){
        Operate.click(UN.findUiobject(Selector.className("android.widget.Button").text("确认购买")));
        return this;
    }

    public BuyRyb assertBuyMoreThanHave(){
        Operate.assertWaitForExists(UN.findUiobject(Selector.text("您可用余额不足，请充值后继续购买")),3);
        return this;
    }
}
