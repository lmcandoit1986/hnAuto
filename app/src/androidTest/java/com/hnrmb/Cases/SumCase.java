package com.hnrmb.Cases;

import com.hnrmb.BaseTests;
import com.hnrmb.Cases.Base.GoodsBase;
import com.hnrmb.Config.Config;
import com.hnrmb.Data.User;
import com.hnrmb.Page.FIPList;
import com.hnrmb.Page.GoodsList;
import com.hnrmb.Page.Login;
import com.hnrmb.Page.Main;
import com.hnrmb.Page.Other;
import com.hnrmb.Utils.AppLaunch;
import com.hnrmb.Utils.CaseInfo;
import com.hnrmb.Utils.DataInfo;
import com.hnrmb.Utils.LogInfo;
import com.hnrmb.Utils.TimeAll;
import com.hnrmb.Utils.WatcherList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SumCase extends BaseTests {


    //B2NGAC6850506946 诺基亚
    //1dcb290a 小米8
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
//            mainObj = Other.unlock(solo);
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
    public void Goods_GoodsListCheck(){
        CaseInfo.setCaseDesc("好物列表及好物详情检查");
        mainObj.actionIntoGoodsList().assertNomal().actionIntoDetailByInstance(0).objectBuy();
    }

    @Test
    public void FIP_FIPListCheck(){
        CaseInfo.setCaseDesc("理财列表并检查前5理财产品详情");
        mainObj.actionIntoFIPList().assertNomal().actionIntoFIPDetail(0).assertNomal().actionBack()
                .actionIntoFIPDetail(1).assertNomal().actionBack()
                .actionIntoFIPDetail(2).assertNomal().actionBack()
                .actionIntoFIPDetail(3).assertNomal().actionBack()
                .actionIntoFIPDetail(4).assertNomal();
    }

    @Test
    public void My_MyMoneyCheck(){
        CaseInfo.setCaseDesc("我的资产页面，金额检查");
        mainObj.actionIntoMy().assertAllMoney("1,100.00")
                .assertAllIncoming("0.00")
                .assertNewIncoming("0.00")
                .assertYCMonkey("0.00")
                .assertLCMonkey("100.00")
                .assertYEMonkey("0.00")
                .assertBankMonkey("1,000.00");
    }

    @Test
    public void Bank_BankCheck(){
        CaseInfo.setCaseDesc("银行+列表并检查前5理财详情");
        mainObj.actionIntoBankList().assertNomal().actionINtoDetail(0).assertTitle().actionBack()
                .actionINtoDetail(1).assertTitle().actionBack()
                .actionINtoDetail(2).assertTitle().actionBack()
                .actionINtoDetail(3).assertTitle().actionBack()
                .actionINtoDetail(4).assertTitle();
    }

    @Test
    public void BalanceIncoming_CheckBalanceIncoming(){
        CaseInfo.setCaseDesc("余额盈页面及金额检查");
        mainObj.actionIntoBalanceIncoming().assertAllIncoming("0.00")
                .assertAllMoney("0.00")
                .assertNewIncoming("0.00");
    }

    @Test
    public void Points_CheckMyPoints(){
        CaseInfo.setCaseDesc("我的积分页面检查");
        mainObj.actionIntoMy().actionIntoMyintegral().assertNomal();
    }

    @Test
    public void Hotel_CheckHotel(){
        CaseInfo.setCaseDesc("酒店页面检查");
        mainObj.actionIntoHotel().assertNomal();
    }

    @Test
    public void publicWork_CheckpublicWork(){
        CaseInfo.setCaseDesc("公益页面检查");
        mainObj.actionIntopublicWork().assertNomal();
    }

    @Test
    public void Pay_CheckPay(){
        CaseInfo.setCaseDesc("工资宝页面检查");
        mainObj.actionIntoPay().assertNomal();
    }

}
