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

    public static DeviceInfo DInfo;
    public static Configurator configurator;

    @BeforeClass
    public static void Setup(){
        DInfo = DeviceInfo.getInstance();
        DInfo.setTIMEOUT(3000); // 设置全局隐式等待时间
        configurator = Configurator.getInstance();
        configurator.setWaitForIdleTimeout(1000);
        configurator.setWaitForSelectorTimeout(3000);
        DeviceStatus.wakeUp(DInfo.getMydevice());
    }


    @AfterClass
    public static void TearDown(){

    }
}
