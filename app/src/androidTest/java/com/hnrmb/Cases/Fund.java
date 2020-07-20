package com.hnrmb.Cases;

import com.hnrmb.BaseTests;
import com.hnrmb.Config.Config;
import com.hnrmb.Data.User;
import com.hnrmb.Page.Login;
import com.hnrmb.Page.Main;
import com.hnrmb.Page.Other;
import com.hnrmb.Utils.CaseInfo;
import com.hnrmb.Utils.DataInfo;
import com.hnrmb.Utils.WatcherList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Fund extends BaseTests {
    public String PackageName = "com.hnrmb.salary"; // 包名
    public String Activity = ".module.login.launch.LaunchAct"; // 启动activity
    public long START_TIME;

    public Main mainObj;

    @Before
    public void SetUp(){
        START_TIME = DataInfo.getTime();
        if (Config.Debug) appLaunch.startApp(PackageName,Activity);
        // 升级弹框关闭
        if (!Config.ENV.equals("rel")){
            Other.closeUpdate(solo);
        };
        WatcherList.allException(solo);
        if (Config.Debug){
            mainObj = new Login(solo).actionLoginWithPhoneAndPsw(User.rel_User,User.rel_Login_Psw);
        }
        else{
            mainObj = new Main(solo);
        }

    }

    @After
    public void Teardown(){
        CaseInfo.caseUseTime(String.valueOf(DataInfo.getTime()-START_TIME));
        if (Config.Debug) appLaunch.quitApp(PackageName);
    }

    @Test
    public void Fund_1_BuyMoreThanHave(){
        CaseInfo.setCaseDesc("余额盈购买超可用金额");
        mainObj.actionIntoBalanceIncoming().actionBuy().actionSetMoney("1000").actionSureWithExcept().assertBuyMoreThanHave();
    }

    @Test
    public void Fund_2_BuySuccess(){
        CaseInfo.setCaseDesc("余额盈购买成功");
        mainObj.actionIntoBalanceIncoming().actionBuy().actionSetMoney("2").actionSureSuccess().actionPsw(User.rel_Trade_PSW).assertResultTitleNative();
    }

    @Test
    public void Fund_3_ReedemVirtualAccounts(){
        CaseInfo.setCaseDesc("余额盈实时赎回到账户-成功");
        mainObj.actionIntoBalanceIncoming().actionRedeem().actionSetMoney("1").actionSureSuccess(true).actionPsw(User.rel_Trade_PSW).assertResultTitleNative();
    }

    @Test
    public void Fund_4_ReedemBindCard(){
        CaseInfo.setCaseDesc("余额盈普通赎回到账户-成功");
        mainObj.actionIntoBalanceIncoming().actionRedeem().actionSetMoney("1").actionSureSuccess(false).actionPsw(User.rel_Trade_PSW).assertResultTitleNative();
    }
}
