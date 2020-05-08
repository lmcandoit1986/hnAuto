package com.hnrmb.Cases;

import com.hnrmb.BaseTests;
import com.hnrmb.Cases.Base.GoodsBase;
import com.hnrmb.Config.Config;
import com.hnrmb.Page.FIPList;
import com.hnrmb.Page.GoodsList;
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
    public AppLaunch appLaunch;
    public Main mainObj;

    @Before
    public void SetUp(){
        START_TIME = DataInfo.getTime();
        appLaunch = new AppLaunch(solo);
        appLaunch.startApp(PackageName,Activity);
        // appLaunch.initToastListener();
        // 升级弹框关闭
        if (!Config.ENV.equals("rel")){
            Other.closeUpdate(solo);
        }
        mainObj = Other.unlock(solo);
        TimeAll.sleepTread(3000);
        WatcherList.update(solo);
        WatcherList.closeTV(solo);
    }

    @After
    public void Teardown(){
        CaseInfo.caseUseTime(String.valueOf(DataInfo.getTime()-START_TIME));
        appLaunch.quitApp(PackageName);
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
        LogInfo.i(Other.getVersionCode(solo.getTargetContext())+"");
        CaseInfo.setCaseDesc("我的资产页面，金额检查");
        mainObj.actionIntoMy().assertAllMoney("200.00")
                .assertAllIncoming("0.00")
                .assertNewIncoming("0.00")
                .assertYCMonkey("0.00")
                .assertLCMonkey("200.00")
                .assertYEMonkey("0.00")
                .assertBankMonkey("0.00");
    }

    @Test
    public void Bank_BankCheck(){
        CaseInfo.setCaseDesc("银行+列表并检查前5理财详情");
        mainObj.actionIntoBankList().assertNomal().actionIntoDetail("享存3月").assertNomal().actionBack()
                .actionIntoDetail("享存6月").assertNomal().actionBack()
                .actionIntoDetail("享存1年").assertNomal().actionBack()
                .actionIntoDetail("月月盈1号").assertNomal(1);
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

}
