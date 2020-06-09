package com.hnrmb.Page;

import androidx.test.uiautomator.UiObject;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.DataInfo;
import com.hnrmb.Utils.FailedCase;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.TimeAll;
import com.hnrmb.Utils.UE.EleId;
import com.hnrmb.Utils.UE.EleIndex;
import com.hnrmb.Utils.UE.EleN;
import com.hnrmb.Utils.UE.EleText;
import com.hnrmb.Utils.UiObjectNew;
/**
 * 理财详情页面元素及操作封装
 * 规范：
 * 1、元素定位，以object开头
 * 2、操作，以action开头
 * 3、验证，以assert开头
 */
public class FIPDetail {

    public Solo solo;
    public UiObjectNew UN;
    public String title;
    public FIPDetail(Solo so,String title) {
        solo = so;
        UN = UiObjectNew.getInstance(solo);
        this.title = title;
    }

    private final String back_id = "com.hnrmb.salary:id/head_left_lay";
    private final String title_id = "com.hnrmb.salary:id/head_content_tv";
    private final String buy_class = "android.widget.Button";


    private UiObject objectBack(){
        return UN.findObjectNew(Config.TYPE_ID,back_id);
    }

    private UiObject objectBuy(){
        return UN.findObjectByClass(Config.TYPE_TEXT,"热卖中",buy_class);
    }

    private UiObject objectProfit(){
        return UN.findUiobject(new EleN[]{new EleText(" %")},new EleN[]{new EleIndex(0)});
    }

    private UiObject objectTitle(){
        return UN.findUiobject(new EleN[]{new EleId(title_id),new EleText(this.title)});
    }

    private UiObject objectDays(){
        int index = 2;
        return UN.findUiobject(new EleN[]{new EleText(index,"投资期限")},new EleN[]{new EleIndex(index+1)});
    }

    public FIPDetail assertDays(String day){
        String rel = Operate.getText(objectDays());
        if(!rel.equals(day)) FailedCase.interruptProcess(String.format("投资期限不匹配，预期：%s,实际:%s",day,rel), DataInfo.getDayFormatForIMG());
        return this;
    }

    private UiObject objectLimit(){
        int index = 5;
        return UN.findUiobject(new EleN[]{new EleText(index,"起购金额")},new EleN[]{new EleIndex(index+1)});
    }

    public FIPDetail assertLimit(String limit){
        String rel = Operate.getText(objectLimit());
        if(!rel.equals(limit)) FailedCase.interruptProcess(String.format("起购金额不匹配，预期：%s,实际:%s",limit,rel), DataInfo.getDayFormatForIMG());
        return this;
    }

    private UiObject objectAmount(){
        int index = 10;
        return UN.findUiobject(new EleN[]{new EleText(index,"产品规模(元)")},new EleN[]{new EleIndex(index-2)});
    }

    public FIPDetail assertAmount(String amount){
        String rel = Operate.getText(objectAmount());
        if(!rel.equals(amount)) FailedCase.interruptProcess(String.format("产品规模不匹配，预期：%s,实际:%s",amount,rel), DataInfo.getDayFormatForIMG());
        return this;
    }

    private UiObject objectMax(){
        int index = 12;
        return UN.findUiobject(new EleN[]{new EleText(index,"单笔限额(元)")},new EleN[]{new EleIndex(index-1)});
    }

    public FIPDetail assertMax(String amount){
        String rel = Operate.getText(objectMax());
        if(!rel.equals(amount)) FailedCase.interruptProcess(String.format("单笔限额不匹配，预期：%s,实际:%s",amount,rel), DataInfo.getDayFormatForIMG());
        return this;
    }

    // 返回
    public FIPList actionBack(){
        Operate.click(objectBack());
        return new FIPList(solo);
    }
    // 购买
    public BuyFIP actionBuy(){
        Operate.click(objectBuy());
        return new BuyFIP(solo);
    }
    //判断年化收益率
    public FIPDetail assertProfit(String profit){
        String rel = Operate.getText(objectProfit());
        if(!rel.equals(profit)) FailedCase.interruptProcess(String.format("收益率不匹配，预期：%s,实际:%s",profit,rel), DataInfo.getDayFormatForIMG());
        return this;
    }


    // 用于监控
    public FIPDetail assertNomal(){
        Operate.assertWaitForExists(objectTitle(),10);
        UN.assertWebelementIsDisplay(UN.findObjectNew(Config.TYPE_TEXT,"预期年化收益率"));
        return this;
    }
}
