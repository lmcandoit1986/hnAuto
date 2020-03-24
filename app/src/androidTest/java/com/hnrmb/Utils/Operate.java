package com.hnrmb.Utils;

import android.graphics.Point;

import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;

/**
 * Created by liming on 2020/3/24.
 */

public class Operate {

    public static void click(UiObject item){
        /**
         * 点击操作
         * 验证对象是否支持点击
         * 失败阻断用例执行
         */
        try {
            if(item.isEnabled()&&item.isClickable()){
                item.click();
                return;
            }
            FailedCase.InterruptProcess("element is not Enabled or clickable");
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
            FailedCase.InterruptProcess("UiObjectNotFoundException",DataInfo.getDayFormatForIMG());
        }catch (NullPointerException e) {
            e.printStackTrace();
            FailedCase.InterruptProcess("Click Failed with NullPointerException",DataInfo.getDayFormatForIMG());
        }
    }

    public static void click(UiDevice device, UiObject object){
        /**
         * 点击操作，通过定位元素坐标点击，主要是覆盖元素不可点击的场景
         */
        try {
            device.click(object.getBounds().centerX(),object.getBounds().centerY()-70);//临时特殊处理，后续去掉
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
            FailedCase.InterruptProcess("UiObjectNotFoundException",DataInfo.getDayFormatForIMG());
        }
    }

    public static void click(UiDevice device, int x,int y){
        /**
         * 点击操作，通过坐标完成点击
         */
        device.click(x,y);
    }


    public static void click(UiObject item, Boolean EnblockCase){
        /**
         * 点击对象，EnblockCase=false 失败不阻断用例执行
         */
        if (EnblockCase) {
            click(item);
            return;
        }
        try {
            if(item.isEnabled() && item.isClickable())item.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void swipe(UiDevice device, Point[] points, int steps){
        /**
         * 手势操作，支持多点操作
         */
        device.swipe(points,steps);
    }


}
