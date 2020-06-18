package com.hnrmb.Page;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Selector;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UE.EleN;
import com.hnrmb.Utils.UE.EleText;
import com.hnrmb.Utils.UiObjectNew;

public class PassWord {
    public Solo solo;
    public UiObjectNew UN;
    public PassWord(Solo solo) {
        this.solo = solo;
        UN = UiObjectNew.getInstance(solo);
    }

    public PassWord actionPsw(String psw){
        for(int i=0;i<psw.length();i++){
            Operate.click(UN.findUiobject(new EleN[]{new EleText(1,String.valueOf(psw.charAt(i)))}));
        }
        return this;
    }

    public PassWord assertResultTitle(){
        Operate.assertWaitForExists(UN.findUiobject(Selector.resourceId("com.hnrmb.salary:id/head_content_tv").text("结果详情")),30);
        return this;
    }
}
