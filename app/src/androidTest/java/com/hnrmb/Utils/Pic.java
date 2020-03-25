package com.hnrmb.Utils;

import java.io.IOException;

/**
 * Created by liming on 2020/3/24.
 */

public class Pic {

    private DeviceInfo deviceInfo;
    private volatile String PIC_SAVE_PATH ="/sdcard/hnrmb/";

    public Pic(){
        deviceInfo = DeviceInfo.getInstance();
    }

    public void setPic_save_local_path(String pic_save_local_path) {
        this.PIC_SAVE_PATH = pic_save_local_path;
    }

    public String getPic_save_local_path(){
        return this.PIC_SAVE_PATH;
    }

    public void screenShotWithADB(String PicName){
        LogInfo.i(String.format("take pic use adb,Name:%s",PicName));
        try {
            deviceInfo.getMydevice().executeShellCommand(String.format("screencap %s%s.png",PIC_SAVE_PATH,PicName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
