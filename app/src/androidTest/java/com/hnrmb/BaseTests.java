package com.hnrmb;

import androidx.test.runner.AndroidJUnit4;
import androidx.test.uiautomator.Configurator;

import com.hnrmb.Utils.DeviceInfo;
import com.hnrmb.Utils.DeviceStatus;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class BaseTests {

    public static DeviceInfo deviceInfo;
    public static Configurator configurator;

    @BeforeClass
    public static void setUp(){
        deviceInfo = DeviceInfo.getInstance();
        deviceInfo.setTIMEOUT(3000); // 设置全局隐式等待时间
        configurator = Configurator.getInstance();
        configurator.setWaitForIdleTimeout(1000);
        configurator.setWaitForSelectorTimeout(5000);
//        configurator.setScrollAcknowledgmentTimeout(100);//滚动延时
//        configurator.setActionAcknowledgmentTimeout(5000);
        DeviceStatus.wakeUp(deviceInfo.getMydevice());
    }


    @AfterClass
    public static void tearDown(){

    }
}
