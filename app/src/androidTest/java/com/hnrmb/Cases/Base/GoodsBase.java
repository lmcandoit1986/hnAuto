package com.hnrmb.Cases.Base;

import com.hnrmb.BaseTests;
import com.hnrmb.Config.Config;
import com.hnrmb.Data.Unlock;
import com.hnrmb.Page.GoodsList;
import com.hnrmb.Page.Login;
import com.hnrmb.Page.Main;
import com.hnrmb.Page.Other;
import com.hnrmb.Utils.AppLaunch;
import com.hnrmb.Utils.CaseInfo;
import com.hnrmb.Utils.DataInfo;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.ParseAnnotation;
import com.hnrmb.Utils.TimeAll;
import com.hnrmb.Utils.UiObjectNew;
import com.hnrmb.Utils.WatcherList;

import org.junit.After;
import org.junit.Before;

public class GoodsBase extends BaseTests {

    public String PackageName = "com.hnrmb.salary"; // 包名
    public String Activity = ".module.login.launch.LaunchAct"; // 启动activity

    public final String CLOSE_UPDATE_ID= "com.hnrmb.salary:id/linear_close";//升级弹框关闭按钮
    public long START_TIME;
    public AppLaunch appLaunch;
    public GoodsList goodsList;

    @Before
    public void SetUp(){
        START_TIME = DataInfo.getTime();
        appLaunch = new AppLaunch(solo);
        appLaunch.startApp(PackageName,Activity);
        appLaunch.initToastListener();
        // 升级弹框关闭
        if (!Config.ENV.equals("rel")){
            Other.closeUpdate(solo);
        }
        Other.unlock(solo);
         WatcherList.update(solo);
         WatcherList.closeTV(solo);
        // 跳转到好物页面
        goodsList = new Main(solo).actionIntoGoodsList();

    }

    @After
    public void Teardown(){
        CaseInfo.caseUseTime(String.valueOf(DataInfo.getTime()-START_TIME));
        appLaunch.quitApp(PackageName);
    }
}
