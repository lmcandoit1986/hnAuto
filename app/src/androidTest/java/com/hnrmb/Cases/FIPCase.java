package com.hnrmb.Cases;

import androidx.test.uiautomator.UiObject;

import com.hnrmb.Cases.Base.FIPBase;
import com.hnrmb.Config.Config;
import com.hnrmb.Data.User;
import com.hnrmb.Page.MyFIP;
import com.hnrmb.Utils.CaseInfo;
import com.hnrmb.Utils.LogInfo;
import com.hnrmb.Utils.TimeAll;
import com.hnrmb.Utils.UiObjectNew;

import org.junit.Test;

public class FIPCase extends FIPBase {

    final String FIP_can_buy_name = "长期购买流程测试(勿动）";
    final double FIP_can_buy_rate = 10.00;
    final int FIP_can_buy_day = 365;
    final int FIP_can_buy_step = 5;
    final int FIP_can_buy_min = 10;
    final int FIP_can_buy_max = 100;
    final int FIP_can_buy_amount = 10;

    @Test
    public void FIP_1_buySuccess(){
        CaseInfo.setCaseDesc("正常购买流程-成功");
        main.actionIntoFIPList().actionIntoFIPDetail(FIP_can_buy_name).actionBuy().actionSetMoney("10").actionSure().actionPsw(User.Psw_Trade_FIP).assertIsResultPage();
    }

    @Test
    public void FIP_1_buySuccessNoAcceptService(){
        CaseInfo.setCaseDesc("正常购买流程-成功-手动同意条款");
        main.actionIntoFIPList().actionIntoFIPDetail(FIP_can_buy_name).actionBuy().actionSetMoney("10").accept().actionSure().acceptAlert().actionPsw(User.Psw_Trade_FIP).assertIsResultPage();
    }

    @Test
    public void FIP_1_buyLowerThanMin(){
        CaseInfo.setCaseDesc(String.format("起购金额:%d元，购买1元",FIP_can_buy_min));
        main.actionIntoFIPList().actionIntoFIPDetail(FIP_can_buy_name).actionBuy().actionSetMoney("1").actionSure().assertToast(FIP_can_buy_min+"元起购");
    }

    @Test
    public void FIP_1_buyMoreThanMax(){
        CaseInfo.setCaseDesc(String.format("单笔上限:%d元，购买1000元",FIP_can_buy_max));
        main.actionIntoFIPList().actionIntoFIPDetail(FIP_can_buy_name).actionBuy().actionSetMoney("1000").actionSure().assertToast("最多可购买"+FIP_can_buy_max+"元");
    }

    @Test
    public void FIP_1_buyStepError(){
        CaseInfo.setCaseDesc(String.format("步幅：%d，增幅1",FIP_can_buy_step));
        main.actionIntoFIPList().actionIntoFIPDetail(FIP_can_buy_name).actionBuy().actionSetMoney("21").actionSure().assertToast("购买金额须为"+FIP_can_buy_step+"的整数倍");
    }

    @Test
    public void FIP_1_CheckDetail(){
        CaseInfo.setCaseDesc("验证理财产品规模、收益率、最大、最小、期限属性");
        main.actionIntoFIPList().actionIntoFIPDetail(FIP_can_buy_name).assertDays(FIP_can_buy_day+"").assertProfit(String.format("%.2f",FIP_can_buy_rate))
                .assertAmount(""+FIP_can_buy_amount).assertLimit(FIP_can_buy_min+"").assertMax(""+FIP_can_buy_max);

    }

    @Test
    public void FIP_1_MyFIPAccount(){
        CaseInfo.setCaseDesc("验证我的理财账户页面跳转及金额显示");
        main.actionIntoMy().actionIntoMyFIP().actionIntCiticAcount().assertMoney().assertTitle();

    }

    @Test
    public void FIP_1_MyFIPAccountOut(){
        CaseInfo.setCaseDesc("验证我的理财账户资金转出");
        main.actionIntoMy().actionIntoMyFIP().actionIntCiticAcount().actionOut().actionInputMoney("1").actionMakeSure().actionPsw(User.Psw_Trade_FIP).assertResultTitle();

    }

    @Test
    public void FIP_1_MyFIPAccountIn(){
        CaseInfo.setCaseDesc("验证我的理财账户转入页面及跳转");
        main.actionIntoMy().actionIntoMyFIP().actionIntCiticAcount().actionIn().assertTitle().actionBack().assertTitle();

    }

    @Test
    public void FIP_1_MyFIPAccountDealList(){
        CaseInfo.setCaseDesc("验证我的理财账户交易明细页面跳转");
        main.actionIntoMy().actionIntoMyFIP().actionIntCiticAcount().actionDeal().assertTitle().assertCurrentDayHaveOut().actionBack().assertTitle();

    }

    @Test
    public void FIP_1_MyFIPAccountDetail(){
        CaseInfo.setCaseDesc("验证我的理财账户资金组成相关展示");
        main.actionIntoMy().actionIntoMyFIP().actionIntCiticAcount().actionDetail().assertTitle();
    }

    @Test
    public void FIP_1_MyFIPDetail(){
        CaseInfo.setCaseDesc("验证我的理财持有资产定义弹框及文案");
        main.actionIntoMy().actionIntoMyFIP().assertMyFIPDetail();
    }

    @Test
    public void FIP_1_MyFIPOrder(){
        CaseInfo.setCaseDesc("验证我的理财持有资产定义弹框及文案");
        main.actionIntoMy().actionIntoMyFIP().assertTag(FIP_can_buy_name,"待计息")
                .assertDay(FIP_can_buy_name,"365天")
                .assertMoney(FIP_can_buy_name,FIP_can_buy_day,FIP_can_buy_rate);
    }

    @Test
    public void FIP_1_MyFIPOrderDetail(){
        CaseInfo.setCaseDesc("验证理财持有交易详情跳转");
        main.actionIntoMy().actionIntoMyFIP().actionIntoFIPTradeDetail(FIP_can_buy_name).assertTitle().assertFIPName().actionIntoFIPDetail().assertNomal();
    }

    @Test
    public void FIP_1_MyFIPHistoryOrderList(){
        CaseInfo.setCaseDesc("验证理财历史持有列表及跳转");
        main.actionIntoMy().actionIntoMyFIP().actionIntoHistoryList().assertTag().assertTitle().actionIntoTradeDetail().assertFIPName().actionIntoFIPDetail().assertNomal();
    }





}
