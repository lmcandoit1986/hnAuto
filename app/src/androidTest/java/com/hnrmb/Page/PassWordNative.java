package com.hnrmb.Page;

import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Selector;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UE.EleN;
import com.hnrmb.Utils.UE.EleText;
import com.hnrmb.Utils.UiObjectNew;

public class PassWordNative {
    public Solo solo;
    public UiObjectNew UN;
    public PassWordNative(Solo solo) {
        this.solo = solo;
        UN = UiObjectNew.getInstance(solo);
    }

    public PassWordNative actionPsw(String psw){
        Operate.input(UN.findUiobject(Selector.resourceId("com.hnrmb.salary:id/trader_pwd_input_view")),psw);
        return this;
    }

    public PassWordNative assertResultTitle(){
        Operate.assertWaitForExists(UN.findUiobject(Selector.resourceId("com.hnrmb.salary:id/head_content_tv").text("结果详情")),30);
        return this;
    }

    public PassWordNative assertResultTitleNative(){
        Operate.assertWaitForExists(UN.findUiobject(Selector.resourceId("com.hnrmb.salary:id/tv_toolbar_title").text("交易结果")),30);
        return this;
    }
}
