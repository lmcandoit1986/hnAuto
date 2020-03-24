package com.hnrmb;

import androidx.test.runner.AndroidJUnit4;
import com.hnrmb.Utils.DeviceInfo;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class BaseTests {

    public static DeviceInfo DInfo;

    @BeforeClass
    public static void Setup(){
        DInfo = DeviceInfo.getInstance();
        DInfo.setTIMEOUT(3000); // 设置全局隐式等待时间
    }


    @AfterClass
    public static void TearDown(){

    }
}
