package com.hnrmb.Utils;

import android.graphics.Rect;

import androidx.test.InstrumentationRegistry;
import androidx.test.uiautomator.Configurator;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;

import com.hnrmb.Config.Config;

/**
 * Created by liming on 2020/3/24.
 */

public class UiObjectNew {

    private static UiObjectNew Instance;
    private Solo solo;
    private UiObjectNew(Solo so){
        solo = so;
    }

    public static UiObjectNew getInstance(Solo so){
        if(Instance==null){
            Instance = new UiObjectNew(so);
        }
        return Instance;
    }

    public UiObject findObjectNew(String Type, String Value){
        /**
         * 定位元素
         * 支持id，text，class，desc
         * 会校验是否存在
         * 验证超时
         * 失败阻断用例实现
         */
        
        UiObject item = null;
        switch (Type){
            case Config.TYPE_ID:
                item = solo.getMydevice().findObject(new UiSelector().resourceId(Value));
                break;
            case Config.TYPE_CLASS:
                item = solo.getMydevice().findObject(new UiSelector().className(Value));
                break;
            case Config.TYPE_TEXT:
                item = solo.getMydevice().findObject(new UiSelector().text(Value));
                break;
            case Config.TYPE_DESC:
                item = solo.getMydevice().findObject(new UiSelector().description(Value));
                break;
            default:
                FailedCase.interruptProcess(String.format("Key Error with type:%s",Type),DataInfo.getDayFormatForIMG());
        }
        
        if (item.waitForExists(solo.getTIMEOUT())){
            return item;
        }else {
            FailedCase.interruptProcess(String.format("elemet is not exists in time:%d,Value:%s", solo.getTIMEOUT(),Value),DataInfo.getDayFormatForIMG());
            return null;
        }
    }

    public UiObject findObjectNew(String Type, String Value, Boolean isAssertExists){
        /**
         * 定位元素
         * 支持id，text，class，desc
         * isAssertExists 为true时同findObjectNew(String Type, String Value)方法
         * isAssertExists 为false时不验证是否存在
         * isAssertExists 为false时不对用例产生阻断
         */
        if (isAssertExists){
            return findObjectNew(Type,Value);
        }
        
        switch (Type){
            case "id":
                return solo.getMydevice().findObject(new UiSelector().resourceId(Value));
            case "class":
                return solo.getMydevice().findObject(new UiSelector().className(Value));
            case "text":
                return solo.getMydevice().findObject(new UiSelector().text(Value));
            case "desc":
                return solo.getMydevice().findObject(new UiSelector().description(Value));
            default:
                FailedCase.interruptProcess(String.format("Key Error with type:%s",Type),DataInfo.getDayFormatForIMG());
                return null;
        }

    }

    public UiObject findObjectNew(String Type, String Value,int instance){
        /**
         * 定位元素
         * 支持id，text，class，desc
         * 会校验是否存在
         * 验证超时
         * 失败阻断用例实现
         */
        
        UiObject item = null;
        switch (Type){
            case Config.TYPE_ID:
                item = solo.getMydevice().findObject(new UiSelector().resourceId(Value).instance(instance));
                break;
            case Config.TYPE_CLASS:
                item = solo.getMydevice().findObject(new UiSelector().className(Value).instance(instance));
                break;
            case Config.TYPE_TEXT:
                item = solo.getMydevice().findObject(new UiSelector().text(Value).instance(instance));
                break;
            case Config.TYPE_DESC:
                item = solo.getMydevice().findObject(new UiSelector().description(Value).instance(instance));
                break;
            default:
                FailedCase.interruptProcess(String.format("Key Error with type:%s",Type),DataInfo.getDayFormatForIMG());
        }
        
        if (item.waitForExists(solo.getTIMEOUT())){
            return item;
        }else {
            FailedCase.interruptProcess(String.format("elemet is not exists in time:%d,value:%s", solo.getTIMEOUT(),Value),DataInfo.getDayFormatForIMG());
            return null;
        }
    }

    public UiObject findObjectNew(String Type, String Value,int instance, Boolean isAssertExists){
        /**
         * 定位元素
         * 支持id，text，class，desc
         * isAssertExists 为true时同findObjectNew(String Type, String Value)方法
         * isAssertExists 为false时不验证是否存在
         * isAssertExists 为false时不对用例产生阻断
         */
        if (isAssertExists){
            return findObjectNew(Type,Value,instance);
        }
        
        switch (Type){
            case "id":
                return solo.getMydevice().findObject(new UiSelector().resourceId(Value).instance(instance));
            case "class":
                return solo.getMydevice().findObject(new UiSelector().className(Value).instance(instance));
            case "text":
                return solo.getMydevice().findObject(new UiSelector().text(Value).instance(instance));
            case "desc":
                return solo.getMydevice().findObject(new UiSelector().description(Value).instance(instance));
            default:
                FailedCase.interruptProcess(String.format("Key Error with type:%s",Type),DataInfo.getDayFormatForIMG());
                return null;
        }

    }

    public UiObject findObjectInListView(String ListViewType, String ListViewValue, String text){
        /**
         * 定位元素，从列表中找到指定文本的元素对象
         */
        UiScrollable list =findListViewObject(ListViewType,ListViewValue);
        list.setMaxSearchSwipes(20);
        UiObject target=null;
        try {
            target = list.getChildByText(new UiSelector().className("android.widget.TextView"),text,true);
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
            FailedCase.interruptProcess(String.format("UiObjectNotFoundException with value:%s",text));
        }
        
        if (target.waitForExists(solo.getTIMEOUT())){
            return target;
        }else {
            FailedCase.interruptProcess(String.format("elemet is not exists in time:%d,value:%s", solo.getTIMEOUT(),text),DataInfo.getDayFormatForIMG());
            return null;
        }
    }

    public UiObject findObjectInListView(String ListViewType, String ListViewValue, String childType,String childValue,String text){
        /**
         * 定位元素，从列表中找到指定文本的元素对象
         */
        UiScrollable list =findListViewObject(ListViewType,ListViewValue);

        UiObject target=null;
        try {
            if (childType.equals(Config.TYPE_ID)){
                target = list.getChildByText(new UiSelector().resourceId(childValue),text);
            }else if(childType.equals(Config.TYPE_CLASS)){
                target = list.getChildByText(new UiSelector().className(childValue),text);
            }else{
                target = list.getChildByText(new UiSelector().className(childValue),text);
            }

        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
            FailedCase.interruptProcess(String.format("UiObjectNotFoundException with value:%s",text));
        }

        if (target.waitForExists(solo.getTIMEOUT())){
            return target;
        }else {
            FailedCase.interruptProcess(String.format("elemet is not exists in time:%d,value:%s", solo.getTIMEOUT(),text),DataInfo.getDayFormatForIMG());
            return null;
        }
    }

    public UiObject findObjectWebView(String Type, String Value){
        /**
         * 定位元素
         * 支持id，text，class，desc
         * 会校验是否存在
         * 验证超时
         * 失败阻断用例实现
         */

        UiObject item = findObjectNew(Type,Value,false);

        if (item.waitForExists(solo.getTIMEOUT())){
            try {
                Rect rect = item.getBounds();
                while (true){
                    TimeAll.sleepTread(1000);
                    item = findObjectNew(Type,Value,false);
                    if(rect.equals(item.getBounds())){
                        break;
                    }
                    rect = item.getBounds();
                }
            } catch (UiObjectNotFoundException e) {
                e.printStackTrace();
            }

            return item;
        }else {
            FailedCase.interruptProcess(String.format("elemet is not exists in time:%d,Value:%s", solo.getTIMEOUT(),Value),DataInfo.getDayFormatForIMG());
            return null;
        }
    }

    /**
     * 获取列表对象
     * @param ListViewType
     * @param ListViewValue
     * @return
     */
    public UiScrollable findListViewObject(String ListViewType,String ListViewValue){
        
        UiScrollable list ;
        if (ListViewType.equals(Config.TYPE_CLASS)){
            list = new UiScrollable(new UiSelector().className(ListViewValue));
        }else if(ListViewType.equals(Config.TYPE_ID)){
            list = new UiScrollable(new UiSelector().resourceId(ListViewValue));
        }else{
            LogInfo.e(String.format("key error with type:%s",ListViewType));
            FailedCase.interruptProcess(String.format("key error with type:%s",ListViewType));
            return null;
        }
        return list;
    }

    public void assertWebelementIsDisplay(UiObject uiObject){
        try {
            if(uiObject.getBounds().height()<=10){
                FailedCase.interruptProcess("webview element is't display",DataInfo.getDayFormatForIMG());
            }
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
            FailedCase.interruptProcess("webview element is't display",DataInfo.getDayFormatForIMG());

        }
    }


}
