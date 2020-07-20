package com.hnrmb.Page;

import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Selector;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;

public class ReedemRyb {

    public Solo solo;
    public UiObjectNew UN;
    public ReedemRyb(Solo solo) {
        this.solo = solo;
        UN = UiObjectNew.getInstance(solo);
    }

    public ReedemRyb actionChangeBank(){
        // 交通银行（6313）
        // 电子账户
        // 绑定卡
        Operate.click(UN.findUiobject(Selector.text("交通银行（6313）")));
        Operate.click(UN.findUiobject(Selector.text("电子账户")));
        return this;
    }

    public PassWord actionSureSuccess(Boolean realTime){
        Operate.clickTop(UN.findUiobject(Selector.text("确认赎回").className("android.widget.Button")),true);
        if(realTime){
            Operate.assertWaitForExists(UN.findUiobject(Selector.text("是否确认赎回")),5);
            Operate.click(UN.findUiobject(Selector.text("确认赎回").className("android.view.View")));
        }
        return new PassWord(solo);
    }

    public ReedemRyb actionSetMoney(String Money){
        // 注意前2位不能一样，例如不能买11，可以121
        for(int i=0;i<Money.length();i++){
            Operate.click(UN.findUiobject(Selector.text(String.valueOf(Money.charAt(i)))));
        }
        return this;
    }


}
