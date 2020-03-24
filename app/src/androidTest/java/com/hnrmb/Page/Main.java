package com.hnrmb.Page;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.DeviceInfo;
import com.hnrmb.Utils.LogInfo;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.TimeAll;
import com.hnrmb.Utils.UiObjectNew;


public class Main {

    // com.hnrmb.salary:id/tv_update
    // com.hnrmb.salary:id/linear_close 关闭
    // com.hnrmb.salary:id/iv_toolbar_back
    // com.hnrmb.salary:id/sdv_life_img_one
    // com.hnrmb.salary:id/sdv_life_img_two
    // com.hnrmb.salary:id/xrecycler_home


    public static void intoModule(String ModuleName){
        LogInfo.i(String.format("into module %s",ModuleName));
        Operate.click(DeviceInfo.getInstance().getMydevice(), new UiObjectNew().findObjectNew(Config.TYPE_TEXT,ModuleName));
        TimeAll.sleepTread(5000);
    }



}
