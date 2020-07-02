package com.hnrmb.Cases.Base;

import com.hnrmb.BaseTests;
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
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Selector;
import com.hnrmb.Utils.UiObjectNew;
import com.hnrmb.Utils.WatcherList;

import org.junit.After;
import org.junit.Before;

public class FIPBase extends BaseTests {
    public String PackageName = "com.hnrmb.salary"; // 包名
    public String Activity = ".module.login.launch.LaunchAct"; // 启动activity

    public final String CLOSE_UPDATE_ID= "com.hnrmb.salary:id/linear_close";//升级弹框关闭按钮
    public long START_TIME;
    public AppLaunch appLaunch;
    public Main main;

    @Before
    public void SetUp(){
        START_TIME = DataInfo.getTime();
        appLaunch = new AppLaunch(solo);
        if (Config.Debug) appLaunch.startApp(PackageName,Activity);
//        appLaunch.initToastListener();
        WatcherList.allException(solo);
        // 升级弹框关闭
        if (!Config.ENV.equals("rel")){
//            Other.closeUpdate(solo);
            Operate.click(UiObjectNew.getInstance(solo).findUiobject(Selector.resourceId("com.hnrmb.salary:id/iv_skip")),false,0,1);

        }
        // 跳转到好物页面
        if (Config.Debug) main = new Login(solo).actionReloginWithPhoneAndPsw(User.User_FIP,User.Psw_Login_FIP);

    }

    @After
    public void Teardown(){
        CaseInfo.caseUseTime(String.valueOf(DataInfo.getTime()-START_TIME));
        if (Config.Debug)appLaunch.quitApp(PackageName);
    }
}
