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

    public UiSelector getUiSelector(Ele[] eleList){
        LogInfo.i("begin set uiSelector");
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
                case Config.TYPE_TEXT_2:
                    uiSelector = uiSelector.textStartsWith(e.getValue());
                    break;
                case Config.TYPE_TEXT_1:
                    uiSelector = uiSelector.textMatches(e.getValue());
                    break;
                case Config.TYPE_TEXT_3:
                    uiSelector = uiSelector.textContains(e.getValue());
                    break;
                case Config.TYPE_CLASS:
                    uiSelector = uiSelector.className(e.getValue());
                    break;
                case Config.TYPE_DESC:
                    uiSelector = uiSelector.description(e.getValue());
                    break;
                case "":
                    break;
                default:
                    FailedCase.interruptProcess(String.format("Key Error with type:%s",e.getType()),DataInfo.getDayFormatForIMG());
            }
            if (e.getIndex()!=-99){
                LogInfo.i("匹配index："+e.getIndex());
                uiSelector = uiSelector.index(e.getIndex());
            }

            if (e.getInstance()!=-99){
                LogInfo.i("匹配instance："+e.getInstance());
                uiSelector = uiSelector.instance(e.getInstance());
            }
            MSG.append(e.about());
        }
        LogInfo.i("uiSelector:"+MSG.toString());
        return uiSelector;
    }

    public UiObject findUiobject(Ele[] eleList){
        StringBuilder MSG = new StringBuilder();
        UiSelector uiSelector = getUiSelector(eleList);
        UiObject item = null;
        item =  solo.getMydevice().findObject(uiSelector);
        return item;
    }

    public UiObject findUiobject(Ele[] childeleList,Ele[] targetChildEle){
        UiSelector uiSelector = getUiSelector(childeleList);
        UiObject item = null;
        item =  solo.getMydevice().findObject(uiSelector);

        UiSelector uiSelectorbrother = getUiSelector(targetChildEle);
        UiObject brother = null;
        try {
            brother = item.getFromParent(uiSelectorbrother);
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
            FailedCase.interruptProcess("未能通过元素的兄弟元素完成定位");
        }
        return brother;
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
    }

    public UiObject findObjectNew(String Type, String Value, String idValue){
        /**
         * 定位元素
         * 支持id，text，class，desc
         * 会校验是否存在
         * 验证超时
         * 失败阻断用例实现
         * */
        return findUiobject(new Ele[]{new Ele(Type,Value),new Ele(Config.TYPE_ID,idValue)});
    }

    public UiObject findObjectByClass(String Type, String Value, String ClassName){
        /**
         * 定位元素
         * 支持id，text，class，desc
         * 会校验是否存在
         * 验证超时
         * 失败阻断用例实现
         */
        return findUiobject(new Ele[]{new Ele(Type,Value),new Ele(Config.TYPE_CLASS,ClassName)});
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

    public UiObject findObjectForWathcer(Ele[] eles){
        /**
         * 定位元素
         * 支持id，text，class，desc
         * isAssertExists 为true时同findObjectNew(String Type, String Value)方法
         * isAssertExists 为false时不验证是否存在
         * isAssertExists 为false时不对用例产生阻断
         */
        UiSelector uiSelector = getUiSelector(eles);
        return solo.getMydevice().findObject(uiSelector);

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
        int timeout =10; //秒
        int waittime = 500;// 毫秒
        UiObject item = findObjectNew(Type,Value);

        if (item.waitForExists(timeout*1000)){
            try {
                Rect rect = item.getBounds();
                while (true){
                    TimeAll.sleepTread(waittime);
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
