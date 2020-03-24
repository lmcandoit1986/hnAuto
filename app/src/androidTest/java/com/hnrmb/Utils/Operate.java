package com.hnrmb.Utils;

import android.graphics.Point;

import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;

import com.hnrmb.Config.Config;

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

    public static void swipe(UiDevice device,String type,int Cycle){
        /**
         * 指定方向滑动，上下左右
         * 只支持屏幕上下、左右中心滑动
         */
        int PH =device.getDisplayHeight();
        int PW =device.getDisplayWidth();

        /**
         * type参数，用于控制滑动方向，依次是up，down，left，right
         * index参数，用户控制滑动参数
         */

        int height_up = PH/ 3;
        int height_down = PH / 2 * 2;
        int mid_height = PH / 2;

        int mid_width = PW / 2;
        int width_left = PW / 3;
        int width_right = PW / 3 * 2;

        LogInfo.i((String.format("swipe:%s,time:%d",type,Cycle)));

        if (type.equals(Config.UP)) {
            for (int i = 0; i < Cycle; i++) {
                device.swipe(mid_width, height_down/2, mid_width, height_up/2, 30);
                TimeAll.sleepTread(1000);
            }
        } else if (type.equals(Config.DOWN)) {
            for (int i = 0; i < Cycle; i++) {
                device.swipe(mid_width, height_up, mid_width, height_down, 30);
                TimeAll.sleepTread(1000);
            }
        } else if (type.equals(Config.LEFT)) {
            for (int j = 0; j < Cycle; j++) {
                device.swipe(width_right, mid_height, width_left, mid_height, 5);
                TimeAll.sleepTread(1000);
            }
        } else if (type.equals(Config.RIGHT)) {
            for (int j = 0; j < Cycle; j++) {
                device.swipe(width_left, mid_height, width_right, mid_height, 5);
                TimeAll.sleepTread(1000);
            }
        } else {
            LogInfo.i(String.format("wrong cmd!,To:%s",type));
        }
    }

    public static void swipe(UiDevice device,String type,int X,int Y,int Cycle){
        /**
         * 指定方向滑动，上下左右
         * 支持设置在哪个点开始滑动
         * 未实现
         */
        int PH =device.getDisplayHeight();
        int PW =device.getDisplayWidth();

        /**
         * type参数，用于控制滑动方向，依次是up，down，left，right
         * index参数，用户控制滑动参数
         */

        int height_up = PH/ 3;
        int height_down = PH / 2 * 2;
        int mid_height = PH / 2;

        int mid_width = PW / 2;
        int width_left = PW / 3;
        int width_right = PW / 3 * 2;

        LogInfo.i((String.format("swipe:%s,time:%d",type,Cycle)));

        if (type.equals(Config.UP)) {
            for (int i = 0; i < Cycle; i++) {
                device.swipe(mid_width, height_down/2, mid_width, height_up/2, 30);
                TimeAll.sleepTread(1000);
            }
        } else if (type.equals(Config.DOWN)) {
            for (int i = 0; i < Cycle; i++) {
                device.swipe(mid_width, height_up, mid_width, height_down, 30);
                TimeAll.sleepTread(1000);
            }
        } else if (type.equals(Config.LEFT)) {
            for (int j = 0; j < Cycle; j++) {
                device.swipe(width_right, mid_height, width_left, mid_height, 5);
                TimeAll.sleepTread(1000);
            }
        } else if (type.equals(Config.RIGHT)) {
            for (int j = 0; j < Cycle; j++) {
                device.swipe(width_left, mid_height, width_right, mid_height, 5);
                TimeAll.sleepTread(1000);
            }
        } else {
            LogInfo.i(String.format("wrong cmd!,To:%s",type));
        }
    }

    /**
     * 滑动列表到底部
     * @param list
     * @param MaxSwipes 最大滑动次数（翻页）
     */
    public static void flingToListEnd(UiScrollable list,int MaxSwipes){
        try {
            list.scrollToEnd(MaxSwipes);
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
            FailedCase.InterruptProcess("UiObjectNotFoundException",DataInfo.getDayFormatForIMG());
        }
    }

}
