package com.hnrmb;

import androidx.test.runner.AndroidJUnit4;
import androidx.test.uiautomator.Configurator;

import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.DeviceStatus;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class BaseTests {

    public static Solo solo;

    @BeforeClass
    public static void setUp(){
        solo = Solo.getInstance();
        solo.setWaitForIdleTimeout(2000);
        solo.setWaitForSelectorTimeout(10000);
        // configurator.setScrollAcknowledgmentTimeout(100);//滚动延时
        // configurator.setActionAcknowledgmentTimeout(5000);
        DeviceStatus.wakeUp(solo.getMydevice());
    }


    @AfterClass
    public static void tearDown(){

    }
}
