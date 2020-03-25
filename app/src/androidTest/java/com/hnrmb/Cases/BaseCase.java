package com.hnrmb.Cases;

import com.hnrmb.BaseTests;
import com.hnrmb.Config.Config;
import com.hnrmb.Data.Unlock;
import com.hnrmb.Page.Main;
import com.hnrmb.Utils.AppLaunch;
import com.hnrmb.Utils.LogInfo;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.TimeAll;
import com.hnrmb.Utils.UiObjectNew;
import com.hnrmb.Utils.WatcherList;

import org.junit.After;
import org.junit.Before;

public class BaseCase extends BaseTests {

    public String PackageName = "com.hnrmb.salary"; // 包名
    public String Activity = ".module.login.launch.LaunchAct"; // 启动activity

    public final String CLOSE_UPDATE_ID= "com.hnrmb.salary:id/linear_close";//升级弹框关闭按钮

    @Before
    public void SetUp(){
        new AppLaunch().startApp(deviceInfo.getMydevice(),PackageName,Activity);
        new AppLaunch().initToastListener(deviceInfo.getInstrumentation());
        // 升级弹框关闭
        Operate.click(new UiObjectNew().findObjectNew(Config.TYPE_ID,CLOSE_UPDATE_ID,false),false);
        TimeAll.sleepTread(2000);
        // 解锁
        Operate.swipe(deviceInfo.getMydevice(), Unlock.getLockTrail(deviceInfo.getPhoneWidth(),deviceInfo.getPhoneHeight()),30);
        // 注册监控
        // WatcherList.Update(DInfo.getMydevice());
        // 跳转到好物页面
        Main.actionIntoIV(8);
    }

    @After
    public void Teardown(){
        new AppLaunch().quitApp(deviceInfo.getMydevice(),PackageName);
    }
}
