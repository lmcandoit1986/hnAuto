package com.hnrmb.Utils;

import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;

import com.hnrmb.Config.Config;

/**
 * Created by liming on 2020/3/24.
 */

public class UiObjectNew {

    private DeviceInfo DInfo;

    public UiObjectNew(){
        DInfo = DeviceInfo.getInstance();
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
                item = DInfo.getMydevice().findObject(new UiSelector().resourceId(Value));
                break;
            case Config.TYPE_CLASS:
                item = DInfo.getMydevice().findObject(new UiSelector().className(Value));
                break;
            case Config.TYPE_TEXT:
                item = DInfo.getMydevice().findObject(new UiSelector().text(Value));
                break;
            case Config.TYPE_DESC:
                item = DInfo.getMydevice().findObject(new UiSelector().description(Value));
                break;
            default:
                FailedCase.InterruptProcess(String.format("Key Error with type:%s",Type),DataInfo.getDayFormatForIMG());
        }
        
        if (item.waitForExists(DInfo.getTIMEOUT())){
            return item;
        }else {
            FailedCase.InterruptProcess(String.format("elemet is not exists in time:%d",DInfo.getTIMEOUT()),DataInfo.getDayFormatForIMG());
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
                return DInfo.getMydevice().findObject(new UiSelector().resourceId(Value));
            case "class":
                return DInfo.getMydevice().findObject(new UiSelector().className(Value));
            case "text":
                return DInfo.getMydevice().findObject(new UiSelector().text(Value));
            case "desc":
                return DInfo.getMydevice().findObject(new UiSelector().description(Value));
            default:
                FailedCase.InterruptProcess(String.format("Key Error with type:%s",Type),DataInfo.getDayFormatForIMG());
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
                item = DInfo.getMydevice().findObject(new UiSelector().resourceId(Value).instance(instance));
                break;
            case Config.TYPE_CLASS:
                item = DInfo.getMydevice().findObject(new UiSelector().className(Value).instance(instance));
                break;
            case Config.TYPE_TEXT:
                item = DInfo.getMydevice().findObject(new UiSelector().text(Value).instance(instance));
                break;
            case Config.TYPE_DESC:
                item = DInfo.getMydevice().findObject(new UiSelector().description(Value).instance(instance));
                break;
            default:
                FailedCase.InterruptProcess(String.format("Key Error with type:%s",Type),DataInfo.getDayFormatForIMG());
        }
        
        if (item.waitForExists(DInfo.getTIMEOUT())){
            return item;
        }else {
            FailedCase.InterruptProcess(String.format("elemet is not exists in time:%d",DInfo.getTIMEOUT()),DataInfo.getDayFormatForIMG());
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
                return DInfo.getMydevice().findObject(new UiSelector().resourceId(Value).instance(instance));
            case "class":
                return DInfo.getMydevice().findObject(new UiSelector().className(Value).instance(instance));
            case "text":
                return DInfo.getMydevice().findObject(new UiSelector().text(Value).instance(instance));
            case "desc":
                return DInfo.getMydevice().findObject(new UiSelector().description(Value).instance(instance));
            default:
                FailedCase.InterruptProcess(String.format("Key Error with type:%s",Type),DataInfo.getDayFormatForIMG());
                return null;
        }

    }

    public UiObject findObjectInListView(String ListViewType, String ListViewValue, String text){
        /**
         * 定位元素，从列表中找到指定文本的元素对象
         */
        UiScrollable list =findListViewObject(ListViewType,ListViewValue);
        
        UiObject target=null;
        try {
            target = list.getChildByText(new UiSelector().className("android.widget.TextView"),text);
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
            FailedCase.InterruptProcess(String.format("UiObjectNotFoundException with value:%s",text));
        }
        
        if (target.waitForExists(DInfo.getTIMEOUT())){
            return target;
        }else {
            FailedCase.InterruptProcess(String.format("elemet is not exists in time:%d",DInfo.getTIMEOUT()),DataInfo.getDayFormatForIMG());
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
            FailedCase.InterruptProcess(String.format("key error with type:%s",ListViewType));
            return null;
        }
        return list;
    }


}
