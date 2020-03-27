package com.hnrmb.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liming on 2020/3/24.
 */

public class DataInfo {

    public static String getDayString(){
        return new Date().toString();
    }

    public static String getDayFormatForLog(){
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }

    public static long getTime(){
        return new Date().getTime()/1000;
    }

    public static String getDayFormatForIMG(){
        return new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    }

    public static void main(String[] args){
        System.out.print(DataInfo.getTime()+"\n");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(DataInfo.getTime()+"\n");
        System.out.print(DataInfo.getDayFormatForLog()+"\n");
        System.out.print(DataInfo.getDayFormatForIMG()+"\n");
    }
}
