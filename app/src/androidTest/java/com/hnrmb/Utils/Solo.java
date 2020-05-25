package com.hnrmb.Utils;

import android.app.Instrumentation;
import android.content.Context;
import androidx.test.InstrumentationRegistry;
import androidx.test.uiautomator.Configurator;
import androidx.test.uiautomator.UiDevice;

/**
 * Created by liming on 2020/3/24.
 */

public class Solo {

    private static Solo Instance;
    private UiDevice Mydevice;
    private volatile long TIMEOUT = 30000;
    private Configurator configurator;

    private Solo(){
        Mydevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        configurator = Configurator.getInstance();
    }

    public static Solo getInstance(){
        if(Instance==null){
            Instance = new Solo();
        }
        return Instance;
    }

    public long getTIMEOUT() {
        return TIMEOUT;
    }

    public void setTIMEOUT(long TIMEOUT) {
        this.TIMEOUT = TIMEOUT;
    }

    public UiDevice getMydevice(){
        return Mydevice;
    }

    public Context getMyContext(){
        return InstrumentationRegistry.getInstrumentation().getContext();
    }

    public void setWaitForSelectorTimeout(long timeout){
        this.configurator.setWaitForSelectorTimeout(timeout);
    }

    public void setWaitForIdleTimeout(long timeout){
        this.configurator.setWaitForIdleTimeout(timeout);
    }

    public int getPhoneHeight(){
        return Mydevice.getDisplayHeight();
    }

    public int getPhoneWidth(){
        return Mydevice.getDisplayWidth();
    }

    public String getModule(){
        return (android.os.Build.MODEL).replace("\r","").replace("\n","");
    }

    public String getSdk_version(){
        return android.os.Build.VERSION.SDK;
    }

    public Context getTargetContext(){
        return InstrumentationRegistry.getTargetContext();
    }

    public Instrumentation getInstrumentation(){
        return InstrumentationRegistry.getInstrumentation();
    }
}
