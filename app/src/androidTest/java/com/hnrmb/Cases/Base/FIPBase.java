package com.hnrmb.Cases.Base;

import com.hnrmb.BaseTests;
import com.hnrmb.Config.Config;
import com.hnrmb.Page.FIPList;
import com.hnrmb.Page.GoodsList;
import com.hnrmb.Page.Login;
import com.hnrmb.Page.Other;
import com.hnrmb.Utils.AppLaunch;
import com.hnrmb.Utils.CaseInfo;
import com.hnrmb.Utils.DataInfo;
import com.hnrmb.Utils.WatcherList;

import org.junit.After;
import org.junit.Before;

public class FIPBase extends BaseTests {
    public String PackageName = "com.hnrmb.salary"; // 包名
    public String Activity = ".module.login.launch.LaunchAct"; // 启动activity

    public final String CLOSE_UPDATE_ID= "com.hnrmb.salary:id/linear_close";//升级弹框关闭按钮
    public long START_TIME;
    public AppLaunch appLaunch;
    public FIPList fipList;

    @Before
    public void SetUp(){
        START_TIME = DataInfo.getTime();
        appLaunch = new AppLaunch(solo);
        if (Config.Debug) appLaunch.startApp(PackageName,Activity);
        appLaunch.initToastListener();
        WatcherList.allException(solo);
        // 升级弹框关闭
        if (!Config.ENV.equals("rel")){
            Other.closeUpdate(solo);
        }
        // 跳转到好物页面
        if (Config.Debug) fipList = new Login(solo).actionReloginWithPhoneAndPsw("15801689735","111qqq").actionIntoFIPList();

    }

    @After
    public void Teardown(){
        CaseInfo.caseUseTime(String.valueOf(DataInfo.getTime()-START_TIME));
        if (Config.Debug)appLaunch.quitApp(PackageName);
    }
}
