package com.hnrmb;

import android.os.Bundle;

import androidx.test.runner.AndroidJUnit4;
import androidx.test.uiautomator.Configurator;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.AppLaunch;
import com.hnrmb.Utils.BundleNew;
import com.hnrmb.Utils.LogInfo;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.DeviceStatus;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class BaseTests {

    public static Solo solo;
    public static AppLaunch appLaunch;


    @BeforeClass
    public static void setUp(){
        solo = Solo.getInstance();
        solo.setWaitForIdleTimeout(2000);
        solo.setWaitForSelectorTimeout(5000);
        appLaunch = new AppLaunch(solo);
        // configurator.setScrollAcknowledgmentTimeout(100);//滚动延时
        // configurator.setActionAcknowledgmentTimeout(5000);
        DeviceStatus.wakeUp(solo.getMydevice());
        if (Config.Debug) appLaunch.quitApp("com.hnrmb.salary");
        Bundle bundle = new Bundle();
        bundle.putString("device",solo.getModule());
        new BundleNew(Solo.getInstance().getInstrumentation()).sendStatus(99,bundle);
        LogInfo.i(solo.getModule());
    }


    @AfterClass
    public static void tearDown(){
    }
}
