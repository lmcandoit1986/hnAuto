package com.hnrmb.Page;

import androidx.test.uiautomator.BySelector;

import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Selector;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UE.EleN;
import com.hnrmb.Utils.UE.EleText;
import com.hnrmb.Utils.UiObjectNew;

public class TransferOut {
    public Solo solo;
    public UiObjectNew UN;
    public TransferOut(Solo solo) {
        this.solo = solo;
        UN = UiObjectNew.getInstance(solo);
    }

    public TransferOut assertTitle(){
        Operate.assertWaitForExists(UN.findUiobject(Selector.resourceId("com.hnrmb.salary:id/head_content_tv").text("资金转出")),5);
        return this;
    }

    public CiticAcount actionBack(){
        Operate.click(UN.findUiobject(Selector.resourceId("com.hnrmb.salary:id/head_left_lay")));
        return new CiticAcount(solo);
    }

    public TransferOut actionInputMoney(String money){
        for(int i=0;i<money.length();i++){
            Operate.click(UN.findUiobject(new EleN[]{new EleText(1,String.valueOf(money.charAt(i)))}));
        }
        return this;
    }

    public PassWord actionMakeSure(){
        Operate.click(UN.findUiobject(Selector.text("立即转出").className("android.widget.Button")));
        return new PassWord(solo);
    }

}
