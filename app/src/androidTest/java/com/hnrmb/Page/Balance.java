package com.hnrmb.Page;

import androidx.test.uiautomator.UiObject;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.DataInfo;
import com.hnrmb.Utils.Ele;
import com.hnrmb.Utils.FailedCase;
import com.hnrmb.Utils.MathsObj;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;
/**
 * 余额盈页面元素及操作封装
 * 规范：
 * 1、元素定位，以object开头
 * 2、操作，以action开头
 * 3、验证，以assert开头
 */
public class Balance {

    public Solo solo;
    public UiObjectNew UN;
    public Balance(Solo so) {
        solo = so;
        UN = UiObjectNew.getInstance(solo);
    }

    private final String back_id = "com.hnrmb.salary:id/iv_toolbar_back";
    private final String deal_detail_id = "com.hnrmb.salary:id/tv_toolbar_right";
    private final String all_money_id = "com.hnrmb.salary:id/total_asset_tv";
    private final String new_money_id = "com.hnrmb.salary:id/lastday_value_tv";
    private final String all_incoming_id = "com.hnrmb.salary:id/income_tv";
    private final String buy_id = "com.hnrmb.salary:id/buy_tv";
    // 返回
    private UiObject objectBack(){
        return UN.findUiobject(new Ele[]{new Ele(Config.TYPE_ID,back_id)});
    }
    // 总金额
    private UiObject objectAllMoney(){
        return UN.findUiobject(new Ele[]{new Ele(Config.TYPE_ID,all_money_id)});
    }
    // 最新盈利
    private UiObject objectNewIncoming(){
        return UN.findUiobject(new Ele[]{new Ele(Config.TYPE_ID,new_money_id)});
    }
    // 全部收益
    private UiObject objectAllIncoming(){
        return UN.findUiobject(new Ele[]{new Ele(Config.TYPE_ID,all_incoming_id)});
    }

    public Balance assertAllMoney(String money){
        String moneyreal = Operate.getText(objectAllMoney());
        if (!MathsObj.assertInt(moneyreal)) FailedCase.interruptProcess(String.format("预期金额不符合格式%s",moneyreal), DataInfo.getDayFormatForIMG());
        return this;
    }

    public Balance assertAllIncoming(String money){
        String moneyreal = Operate.getText(objectAllIncoming());
        if (!MathsObj.assertInt(moneyreal)) FailedCase.interruptProcess(String.format("预期金额不符合格式%s",moneyreal), DataInfo.getDayFormatForIMG());
        return this;
    }

    public Balance assertNewIncoming(String money){
        String moneyreal = Operate.getText(objectNewIncoming());
        if (!MathsObj.assertInt(moneyreal)) FailedCase.interruptProcess(String.format("预期金额不符合格式%s",moneyreal), DataInfo.getDayFormatForIMG());
        return this;
    }


}
