package com.hnrmb.Cases;

import androidx.test.uiautomator.UiObject;

import com.hnrmb.Cases.Base.FIPBase;
import com.hnrmb.Config.Config;
import com.hnrmb.Page.MyFIP;
import com.hnrmb.Utils.CaseInfo;
import com.hnrmb.Utils.LogInfo;
import com.hnrmb.Utils.TimeAll;
import com.hnrmb.Utils.UiObjectNew;

import org.junit.Test;

public class FIPCase extends FIPBase {

    @Test
    public void buySuccess(){
        CaseInfo.setCaseDesc("正常购买流程-成功");
        fipList.actionIntoFIPDetail("长期购买流程测试(勿动）").actionBuy().actionSetMoney("10").actionSure().actionPsw("111111").assertIsResultPage().actionFinish();
    }

    @Test
    public void buySuccessNoAcceptService(){
        CaseInfo.setCaseDesc("正常购买流程-成功-手动同意条款");
        fipList.actionIntoFIPDetail("长期购买流程测试(勿动）").actionBuy().actionSetMoney("10").accept().actionSure().acceptAlert().actionPsw("111111").assertIsResultPage().actionFinish();
    }

    @Test
    public void buyLowerThanMin(){
        CaseInfo.setCaseDesc("起购金额:10元，购买1元");
        fipList.actionIntoFIPDetail("长期购买流程测试(勿动）").actionBuy().actionSetMoney("1").actionSure().assertToast("10元起购");
    }

    @Test
    public void buyMoreThanMax(){
        CaseInfo.setCaseDesc("单笔上限:100元，购买1000元");
        fipList.actionIntoFIPDetail("长期购买流程测试(勿动）").actionBuy().actionSetMoney("1000").actionSure().assertToast("最多可购买100元");
    }

    @Test
    public void buyStepError(){
        CaseInfo.setCaseDesc("步幅：5，增幅1");
        fipList.actionIntoFIPDetail("长期购买流程测试(勿动）").actionBuy().actionSetMoney("21").actionSure().assertToast("购买金额须为5的整数倍");
    }

    @Test
    public void CheckDetail(){
        CaseInfo.setCaseDesc("验证理财产品规模、收益率、最大、最小、期限属性");
        fipList.actionIntoFIPDetail("长期购买流程测试(勿动）").assertDays("365").assertProfit("10.00").assertAmount("10").assertLimit("10").assertMax("100");

    }


}
