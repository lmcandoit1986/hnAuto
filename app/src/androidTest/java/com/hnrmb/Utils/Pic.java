package com.hnrmb.Utils;

import java.io.IOException;

/**
 * Created by liming on 2020/3/24.
 */

public class Pic {

    private DeviceInfo DInfo;
    private volatile String pic_save_local_path ="/sdcard/hnrmb/";

    public Pic(){
        DInfo = DeviceInfo.getInstance();
    }

    public void setPic_save_local_path(String pic_save_local_path) {
        this.pic_save_local_path = pic_save_local_path;
    }

    public String getPic_save_local_path(){
        return this.pic_save_local_path;
    }

    public void screenShotWithADB(String PicName){
        LogInfo.i(String.format("take pic use adb,Name:%s",PicName));
        try {
            DInfo.getMydevice().executeShellCommand(String.format("screencap %s%s.png",pic_save_local_path,PicName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
