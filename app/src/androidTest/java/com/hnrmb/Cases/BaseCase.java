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

import org.junit.After;
import org.junit.Before;

public class BaseCase extends BaseTests {

    public String PackageName = "com.hnrmb.salary";
    public String Activity = ".module.login.launch.LaunchAct";

    @Before
    public void SetUp(){
        new AppLaunch().StartApp(DInfo.getMydevice(),PackageName,Activity);
        new AppLaunch().initToastListener(DInfo.getInstrumentation());
        // 如果有升级弹框，关闭
        Operate.click(new UiObjectNew().findObjectNew(Config.TYPE_ID,"com.hnrmb.salary:id/linear_close",false),false);
        TimeAll.sleepTread(2000);
        /**
         * 监听
        DInfo.getMydevice().registerWatcher("closeUpdate", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                UiObject item = DInfo.getMydevice().findObject(new UiSelector().resourceId("com.hnrmb.salary:id/tv_update"));
                if(item.exists()){
                    Log_qa.print_i("asdasfasfasfasfasf");
                    try {
                        DInfo.getMydevice().findObject(new UiSelector().resourceId("com.hnrmb.salary:id/linear_close")).click();
                    } catch (UiObjectNotFoundException e) {
                        e.printStackTrace();
                    }
                    return true;
                }
                return false;
            }
        });
         */

        // 解锁
        Operate.swipe(DInfo.getMydevice(), Unlock.getLockTrail(DInfo.getPhoneWidth(),DInfo.getPhoneHeight()),30);
        // 跳转到好物页面
        Main.intoModule(8);
    }

    @After
    public void Teardown(){
        new AppLaunch().quitApp(DInfo.getMydevice(),PackageName);
    }
}
