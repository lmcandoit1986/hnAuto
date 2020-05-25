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

import org.junit.Test;

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

    public UiObject findUiobject(Ele[] eleList){
        return findUiobject(eleList,true);
    }

    public UiObject findUiobject(Ele[] eleList,Boolean isAssert){
        UiSelector uiSelector = new UiSelector();
        StringBuilder MSG = new StringBuilder();
        for(Ele e : eleList){
            switch (e.getType()){
                case Config.TYPE_ID:
                    uiSelector = uiSelector.resourceId(e.getValue());
                    break;
                case Config.TYPE_TEXT:
                    uiSelector = uiSelector.text(e.getValue());
                    break;
                case Config.TYPE_CLASS:
                    uiSelector = uiSelector.className(e.getValue());
                    break;
                case Config.TYPE_DESC:
                    uiSelector = uiSelector.description(e.getValue());
                    break;
                default:
                    FailedCase.interruptProcess(String.format("Key Error with type:%s",e.getType()),DataInfo.getDayFormatForIMG());
            }
            if (e.getIndex()>=0){
                LogInfo.i("匹配index："+e.getIndex());
                uiSelector = uiSelector.index(e.getIndex());
            }

            if (e.getInstance()>=0){
                LogInfo.i("匹配instance："+e.getInstance());
                uiSelector = uiSelector.instance(e.getInstance());
            }
            MSG.append(e.about());

        }
        UiObject item = null;
        item =  solo.getMydevice().findObject(uiSelector);

        if (item.waitForExists(solo.getTIMEOUT())){
            return item;
        }else {
            if (isAssert) FailedCase.interruptProcess(String.format("elemet is not exists in time:%d,Value:%s", solo.getTIMEOUT(),MSG),DataInfo.getDayFormatForIMG());
            return null;
        }
    }

    public UiObject findUiobject(Ele[] eleList,int timeout){
        UiSelector uiSelector = new UiSelector();
        StringBuilder MSG = new StringBuilder();
        for(Ele e : eleList){
            switch (e.getType()){
                case Config.TYPE_ID:
                    uiSelector = uiSelector.resourceId(e.getValue());
                    break;
                case Config.TYPE_TEXT:
                    uiSelector = uiSelector.text(e.getValue());
                    break;
                case Config.TYPE_CLASS:
                    uiSelector = uiSelector.className(e.getValue());
                    break;
                case Config.TYPE_DESC:
                    uiSelector = uiSelector.description(e.getValue());
                    break;
                default:
                    FailedCase.interruptProcess(String.format("Key Error with type:%s",e.getType()),DataInfo.getDayFormatForIMG());
            }
            if (e.getIndex()>=0){
                LogInfo.i("匹配index："+e.getIndex());
                uiSelector = uiSelector.index(e.getIndex());
            }

            if (e.getInstance()>=0){
                LogInfo.i("匹配instance："+e.getInstance());
                uiSelector = uiSelector.instance(e.getInstance());
            }
            MSG.append(e.about());

        }
        UiObject item = null;
        item =  solo.getMydevice().findObject(uiSelector);

        if (item.waitForExists(timeout)){
            return item;
        }else {
            FailedCase.interruptProcess(String.format("elemet is not exists in time:%d,Value:%s", solo.getTIMEOUT(),MSG),DataInfo.getDayFormatForIMG());
            return null;
        }
    }

    public UiObject findObjectNew(String Type, String Value){
        /**
         * 定位元素
         * 支持id，text，class，desc
         * 会校验是否存在
         * 验证超时
         * 失败阻断用例实现
         */

        return findUiobject(new Ele[]{new Ele(Type,Value)});

        /**
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
         */
    }

    public UiObject findObjectNew(String Type, String Value, String idValue){
        /**
         * 定位元素
         * 支持id，text，class，desc
         * 会校验是否存在
         * 验证超时
         * 失败阻断用例实现


        UiObject item = null;
        switch (Type){
            case Config.TYPE_ID:
                item = solo.getMydevice().findObject(new UiSelector().resourceId(Value));
                break;
            case Config.TYPE_CLASS:
                item = solo.getMydevice().findObject(new UiSelector().resourceId(idValue).className(Value));
                break;
            case Config.TYPE_TEXT:
                item = solo.getMydevice().findObject(new UiSelector().resourceId(idValue).text(Value));
                break;
            case Config.TYPE_DESC:
                item = solo.getMydevice().findObject(new UiSelector().resourceId(idValue).description(Value));
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
         */
        return findUiobject(new Ele[]{new Ele(Type,Value),new Ele(Config.TYPE_ID,idValue)});
    }

    public UiObject findObjectSetTimeout(String Type, String Value, int timeout){
        /**
         * 定位元素
         * 支持id，text，class，desc
         * 会校验是否存在
         * 验证超时
         * 失败阻断用例实现


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

        if (item.waitForExists(timeout)){
            return item;
        }else {
            FailedCase.interruptProcess(String.format("elemet is not exists in time:%d,Value:%s", solo.getTIMEOUT(),Value),DataInfo.getDayFormatForIMG());
            return null;
        }
        */
        return findUiobject(new Ele[]{new Ele(Type,Value)},timeout);
    }

    public UiObject findObjectByClass(String Type, String Value, String ClassName){
        /**
         * 定位元素
         * 支持id，text，class，desc
         * 会校验是否存在
         * 验证超时
         * 失败阻断用例实现


        UiObject item = null;
        switch (Type){
            case Config.TYPE_ID:
                item = solo.getMydevice().findObject(new UiSelector().className(ClassName).resourceId(Value));
                break;
            case Config.TYPE_CLASS:
                item = solo.getMydevice().findObject(new UiSelector().className(Value));
                break;
            case Config.TYPE_TEXT:
                item = solo.getMydevice().findObject(new UiSelector().className(ClassName).text(Value));
                break;
            case Config.TYPE_DESC:
                item = solo.getMydevice().findObject(new UiSelector().className(ClassName).description(Value));
                break;
            default:
                FailedCase.interruptProcess(String.format("Key Error with type:%s",Type),DataInfo.getDayFormatForIMG());
        }

        if (item.waitForExists(solo.getTIMEOUT())){
            return item;
        }else {
            FailedCase.interruptProcess(String.format("elemet is not exists in time:%d,Value:%s,Class:%s", solo.getTIMEOUT(),Value,ClassName),DataInfo.getDayFormatForIMG());
            return null;
        }
         */
        return findUiobject(new Ele[]{new Ele(Type,Value),new Ele(Config.TYPE_CLASS,ClassName)});
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
            return findUiobject(new Ele[]{new Ele(Type,Value)});
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
        */
        return findUiobject(new Ele[]{new Ele(Type,Value,instance)});
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
            return findUiobject(new Ele[]{new Ele(Type,Value,instance)});
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
