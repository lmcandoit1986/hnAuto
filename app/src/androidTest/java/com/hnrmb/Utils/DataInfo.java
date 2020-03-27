package com.hnrmb.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by liming on 2020/3/24.
 */

public class DataInfo {

    public static String getDayString(){
        return new Date().toString();
    }

    /**
     * 返回时间，格式 2020-03-27 01:54:10 精确到秒
     * @return
     */
    public static String getDayFormatForLog(){
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }

    /**
     * 返回时间戳，精确到秒
     * @return
     */
    public static long getTime(){
        return new Date().getTime()/1000;
    }

    public static String formatData(Date date,String FormatString){
        return new SimpleDateFormat(FormatString).format(date);
    }

    /**
     * 返回时间，格式 20200327015410 精确到秒
     * @return
     */
    public static String getDayFormatForIMG(){
        return new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    }

    /**
     * 往后延x天
     * @param days
     * @return
     */
    public static Date getDayPostponeDay(int days){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,days);
        return calendar.getTime();

    }

    /**
     * 往后延x时
     * @param days
     * @return
     */
    public static Date getDayPostponeHours(int days){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY,days);
        return calendar.getTime();

    }

    /**
     * 往后延x月
     * @param days
     * @return
     */
    public static Date getDayPostponeMonth(int days){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,days);
        return calendar.getTime();

    }

    /**
     * 往后延x年
     * @param days
     * @return
     */
    public static Date getDayPostponeYear(int days){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR,days);
        return calendar.getTime();

    }

    public static void main(String[] args){
        System.out.print(DataInfo.getTime()+"\n");
        System.out.print(DataInfo.formatData(DataInfo.getDayPostponeDay(1),"yyyy-MM-dd")+"\n");
        System.out.print(DataInfo.formatData(DataInfo.getDayPostponeMonth(1),"yyyy-MM-dd")+"\n");
        System.out.print(DataInfo.formatData(DataInfo.getDayPostponeHours(1),"yyyy-MM-dd hh")+"\n");
        System.out.print(DataInfo.getDayFormatForLog()+"\n");
        System.out.print(DataInfo.getDayFormatForIMG()+"\n");
    }
}
