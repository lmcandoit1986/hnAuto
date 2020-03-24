package com.hnrmb.Page;

import android.graphics.Path;

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


    public static void intoModule(int instance){
        /**
         * 0 余额盈
         * 1 投资圈
         * 2 理财
         * 3 酒店
         * 4 银行+
         * 5 公益
         * 6 保险
         * 7 哆啦A梦
         * 8 好物
         * 9
         */
        LogInfo.i(String.format("into module"));
        Operate.click(new UiObjectNew().findObjectNew(Config.TYPE_ID,"com.hnrmb.salary:id/iv_icon",instance));
//        Operate.click(DeviceInfo.getInstance().getMydevice(), new UiObjectNew().findObjectNew(Config.TYPE_TEXT,ModuleName));
        TimeAll.sleepTread(3000);
    }



}
