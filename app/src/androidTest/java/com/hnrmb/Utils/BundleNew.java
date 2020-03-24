package com.hnrmb.Utils;

import android.app.Instrumentation;
import android.os.Bundle;
import androidx.test.uiautomator.IAutomationSupport;

/**
 * Created by liming on 2020/3/24.
 */

public class BundleNew implements IAutomationSupport {

    private Instrumentation mInstrumentation;

    public BundleNew(Instrumentation instrumentation) {
        mInstrumentation = instrumentation;
    }

    @Override
    public void sendStatus(int resultCode, Bundle status) {
        mInstrumentation.sendStatus(resultCode, status);
    }
}
