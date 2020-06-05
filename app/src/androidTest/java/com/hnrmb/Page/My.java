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
 * 我的页面元素及操作封装
 * 规范：
 * 1、元素定位，以object开头
 * 2、操作，以action开头
 * 3、验证，以assert开头
 */
public class My {

    private Solo solo;
    private UiObjectNew UN;
    public My(Solo so){
        solo = so;
        UN = UiObjectNew.getInstance(solo);
        // 等待接口数据返回,设置最长等待时间3分钟
        long End = DataInfo.getTime()+ 3 * 60;
        while (true){
            if (UN.findUiobject(new Ele[]{new Ele(Config.TYPE_TEXT,"获取中")},1000,false)==null){
                break;
            }
            if (DataInfo.getTime() >= End){
                break;
            }
        }
    }

    private final String go_personal_id = "com.hnrmb.salary:id/img_my_head";
    private final String all_money_id = "com.hnrmb.salary:id/tv_total_asset";
    private final String new_incoming_id = "com.hnrmb.salary:id/tv_latest_get_amount";
    private final String all_incoming_id = "com.hnrmb.salary:id/tv_latest_get_amount";
    private final String yc_money_id = "com.hnrmb.salary:id/tv_ebank_amount";
    private final String lc_money_id = "com.hnrmb.salary:id/tv_lcb_amount";
    private final String ye_money_id = "com.hnrmb.salary:id/tv_fund_amount";
    private final String bank_money_id = "com.hnrmb.salary:id/tv_js_financing_amount";
    private final String message_id = "com.hnrmb.salary:id/lay_to_message";
    private final String hide_id = "com.hnrmb.salary:id/hide_show_img";
    private final String incoming_msg_id = "com.hnrmb.salary:id/tv_latest_get";
    private final String sign_id = "com.hnrmb.salary:id/xdlct_signin";

    // 签到入口
    private UiObject objectSign(){
        return UN.findObjectNew(Config.TYPE_ID,sign_id);
    }
    // 切换到个人中心
    private UiObject objectGoPersonal(){
        return UN.findObjectNew(Config.TYPE_ID,go_personal_id);
    }
    // 总资产
    private UiObject objectAllMoney(){
        return UN.findObjectNew(Config.TYPE_ID,all_money_id);
    }
    // 最新收益
    private UiObject objectNewIncoming(){
        return UN.findObjectNew(Config.TYPE_ID,new_incoming_id);
    }
    // 累计收益
    private UiObject objectAllIncoming(){
        return UN.findObjectNew(Config.TYPE_ID,all_incoming_id);
    }
    // 云成账户余额
    private UiObject objectYCMoney(){
        return UN.findObjectNew(Config.TYPE_ID,yc_money_id);
    }
    // 理财金额
    private UiObject objectLCMoney(){
        return UN.findObjectNew(Config.TYPE_ID,lc_money_id);
    }
    // 余额盈
    private UiObject objectYEMoney(){
        return UN.findObjectNew(Config.TYPE_ID,ye_money_id);
    }
    // 银行+
    private UiObject objectBankMoney(){
        return UN.findObjectNew(Config.TYPE_ID,bank_money_id);
    }
    // 消息中心
    private UiObject objectMessage(){
        return UN.findObjectNew(Config.TYPE_ID,message_id);
    }
    // 隐藏金额显示
    private UiObject objectHide(){
        return UN.findObjectNew(Config.TYPE_ID,hide_id);
    }
    // 最新收益解释
    private UiObject objectIncomingMsg(){
        return UN.findObjectNew(Config.TYPE_ID,incoming_msg_id);
    }


    public Personal actionGoPersonal(){
        Operate.click(objectGoPersonal());
        return new Personal(solo);
    }

    public Myintegral actionIntoMyintegral(){
        Operate.clickAndWaitForNewWindow(objectSign());
        return new Myintegral(solo);
    }

    public My assertAllMoney(String money){
        String ExpectMoney = Operate.getText(objectAllMoney());
        if (MathsObj.assertInt(ExpectMoney)) FailedCase.interruptProcess(String.format("预期金额不符合格式%s",ExpectMoney), DataInfo.getDayFormatForIMG());
        return this;
    }

    public My assertNewIncoming(String money){
        String ExpectMoney = Operate.getText(objectNewIncoming());
        if (MathsObj.assertInt(ExpectMoney)) FailedCase.interruptProcess(String.format("预期金额不符合格式%s",ExpectMoney), DataInfo.getDayFormatForIMG());
        return this;
    }

    public My assertAllIncoming(String money){
        String ExpectMoney = Operate.getText(objectAllIncoming());
        if (MathsObj.assertInt(ExpectMoney)) FailedCase.interruptProcess(String.format("预期金额不符合格式%s",ExpectMoney), DataInfo.getDayFormatForIMG());
        return this;
    }

    public My assertYCMonkey(String money){
        String ExpectMoney = Operate.getText(objectYCMoney());
        if (MathsObj.assertInt(ExpectMoney)) FailedCase.interruptProcess(String.format("预期金额不符合格式%s",ExpectMoney), DataInfo.getDayFormatForIMG());
        return this;
    }

    public My assertYEMonkey(String money){
        String ExpectMoney = Operate.getText(objectYEMoney());
        if (MathsObj.assertInt(ExpectMoney)) FailedCase.interruptProcess(String.format("预期金额不符合格式%s",ExpectMoney), DataInfo.getDayFormatForIMG());
        return this;
    }

    public My assertLCMonkey(String money){
        String ExpectMoney = Operate.getText(objectLCMoney());
        if (MathsObj.assertInt(ExpectMoney)) FailedCase.interruptProcess(String.format("预期金额不符合格式%s",ExpectMoney), DataInfo.getDayFormatForIMG());
        return this;
    }

    public My assertBankMonkey(String money){
        String ExpectMoney = Operate.getText(objectBankMoney());
        if (MathsObj.assertInt(ExpectMoney)) FailedCase.interruptProcess(String.format("预期金额不符合格式%s",ExpectMoney), DataInfo.getDayFormatForIMG());
        return this;
    }

}
