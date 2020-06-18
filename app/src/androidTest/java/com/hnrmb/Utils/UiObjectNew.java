package com.hnrmb.Utils;

import android.graphics.Rect;

import androidx.test.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.BySelector;
import androidx.test.uiautomator.Configurator;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.UE.EleId;
import com.hnrmb.Utils.UE.EleN;

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

    /**
     * 获取UISelector 对象
     * @param eleNS ,EleN 列表，一个元素代表一个筛选条件，可以多个筛选条件一起来定位，注意：index/instance 可和其他定位方式作为一个条件
     * @return
     */
    public UiSelector getUiSelector(EleN[] eleNS){
        UiSelector uiSelector = new UiSelector();
        StringBuilder MSG = new StringBuilder();
        for (EleN e :eleNS){
            if (e.getClassName() != null){
                MSG.append("class:"+e.getClassName()+" ");
                uiSelector = uiSelector.className(e.getClassName());
            }

            if (e.getId() != null){
                MSG.append("id:"+e.getId()+" ");
                uiSelector = uiSelector.resourceId(e.getId());
            }

            if (e.getText() != null){
                MSG.append("text:"+e.getText()+" ");
                uiSelector = uiSelector.text(e.getText());
            }

            if (e.getIndex() != -99){
                MSG.append("index:"+e.getIndex()+" ");
                uiSelector = uiSelector.index(e.getIndex());
            }

            if (e.getInstance() != -99){
                MSG.append("instance:"+e.getInstance()+" ");
                uiSelector = uiSelector.instance(e.getInstance());
            }

            if (e.getDesc() != null){
                MSG.append("desc:"+e.getDesc()+" ");
                uiSelector = uiSelector.description(e.getDesc());
            }

            if (e.getTextContain() != null){
                MSG.append("textcontain:"+e.getTextContain()+" ");
                uiSelector = uiSelector.textContains(e.getTextContain());
            }

            if (e.getTextMatch() != null){
                MSG.append("textmatch:"+e.getTextMatch()+" ");
                uiSelector = uiSelector.textMatches(e.getTextMatch());
            }

            if (e.getTextStartWith() != null){
                MSG.append("classStart:"+e.getTextStartWith()+" ");
                uiSelector = uiSelector.textStartsWith(e.getTextStartWith());
            }
        }
//        LogInfo.i("uiSelector:"+MSG.toString());
        return uiSelector;
    }

    /**
     * 定位对象，返回Uiobject对象
     * @param eleNS ,EleN 列表，一个元素代表一个筛选条件，可以多个筛选条件一起来定位，注意：index/instance 可和其他定位方式作为一个条件
     * @return
     */
    public UiObject findUiobject(EleN[] eleNS){
        UiSelector uiSelector = getUiSelector(eleNS);
        return findUiobject(uiSelector);
    }

    public UiObject findUiobject(UiSelector selector){
        LogInfo.i("定位元素，Uiselector:"+selector.toString());
        return solo.getMydevice().findObject(selector);
    }

    public UiObject findUiobject(UiSelector selector,UiSelector brotherSelector){
        LogInfo.i("定位元素，定位 Uiselector:"+selector.toString()+"，兄弟元素 Uiselector"+brotherSelector.toString());
        UiObject uiObject= solo.getMydevice().findObject(selector);
        try {
            UiObject brother = uiObject.getFromParent(brotherSelector);
            return brother;
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
            FailedCase.interruptProcess("未能通过同级父类查找到目标元素");
            return null;
        }
    }

    /**
     * 获取UISelector 对象
     * @param eleList，Ele 列表，一个元素代表一个筛选条件，可以多个筛选条件一起来定位，注意：index/instance 可和其他定位方式作为一个条件，和EleN 只是写法不同
     * @return
     */
    public UiSelector getUiSelector(Ele[] eleList){
//        LogInfo.i("begin set uiSelector");
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
//                LogInfo.i("匹配index："+e.getIndex());
                uiSelector = uiSelector.index(e.getIndex());
            }

            if (e.getInstance()!=-99){
//                LogInfo.i("匹配instance："+e.getInstance());
                uiSelector = uiSelector.instance(e.getInstance());
            }
            MSG.append(e.about());
        }
//        LogInfo.i("uiSelector:"+MSG.toString());
        return uiSelector;
    }

    /**
     * 定位对象，返回Uiobject对象
     * @param eleList Ele 列表，一个元素代表一个筛选条件，可以多个筛选条件一起来定位，注意：index/instance 可和其他定位方式作为一个条件，和EleN 只是写法不同
     * @return
     */
    public UiObject findUiobject(Ele[] eleList){
        UiSelector uiSelector = getUiSelector(eleList);
        return  findUiobject(uiSelector);
    }

    public < E > UiObject findUiobject(E eleList){
        if (eleList.toString().equals("")){
            eleList.getClass().getName();
        }
        UiSelector uiSelector = Selector.className("");
        return  findUiobject(uiSelector);
    }

    /**
     * 定位对象，返回Uiobject2对象
     * @param bySelector 直接传入筛选条件 BySelector 对象
     * @return
     */
    public UiObject2 findUiobject2(BySelector bySelector){
        LogInfo.i("定位元素，BySelector:"+bySelector.toString());
        return solo.getMydevice().findObject(bySelector);
    }

    /**
     * 定位对象，返回Uiobject2对象
     * @param child 可以准确定位的元素的筛选条件对象 BySelector
     * @param toParent 具体包含目标子对象的父类，需要往上查找次数,直接父类，1，父类的父类，2，依次类推
     * @param target 子对象的定位筛选条件BySelector对象
     * @return
     */
    public UiObject2 findUiobject2ByParent(BySelector child,int toParent,BySelector target){
        UiObject2 childObj = findUiobject2(child);
        UiObject2 parent =null;
        for(int i=0;i<toParent;i++){
            parent = childObj.getParent();
            childObj = parent;
        }
        return parent.findObject(target);

    }

    /**
     * 定位对象，返回Uiobject2对象
     * @param child 可以准确定位的元素的筛选条件对象 BySelector
     * @param target 子对象的定位筛选条件BySelector对象
     * @return
     */
    public UiObject2 findUiobject2ByParent(BySelector child,BySelector target){
        UiObject2 childObj = findUiobject2(child);
        UiObject2 parent =null;
        for(int i=0;i<3;i++){
            parent = childObj.getParent();
            if(Operate.assertWaitForExists(parent.findObject(target),0,false)){
                return parent.findObject(target);
            }
            childObj = parent;
        }
        return null;

    }

    /**
     * 定位对象，返回Uiobject对象
     * @param childeleList 可以准确定位的元素的筛选条件的Ele 对象列表
     * @param targetChildEle 子对象的定位筛选条件的Ele 对象列表，注意需要在同一个父类下，不能跳级定位
     * @return
     */
    public UiObject findUiobject(Ele[] childeleList,Ele[] targetChildEle){
        UiSelector uiSelector = getUiSelector(childeleList);
        UiObject item =  findUiobject(uiSelector);

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

    /**
     * 同 findUiobject(Ele[] childeleList,Ele[] targetChildEle) ，只是传参不同
     * @param childeleList
     * @param targetChildEle
     * @return
     */
    public UiObject findUiobject(EleN[] childeleList,EleN[] targetChildEle){
        UiSelector uiSelector = getUiSelector(childeleList);
        UiObject item =  findUiobject(uiSelector);

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

    /**
     * 定位简单写法，适用于最简单的单一定位方式
     * @param Type 定位方式
     * @param Value 定位值
     * @return
     */
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

    /**
     * 2维度定位方式，适合id 和 另一维度组合定位
     * @param Type
     * @param Value
     * @param idValue
     * @return
     */
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

    /**
     * 2维度定位方式，适合class 和 另一维度组合定位
     * @param Type
     * @param Value
     * @param ClassName
     * @return
     */
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

    /**
     * 2维度定位方式，instance 和 另一维度组合定位
     * @param Type
     * @param Value
     * @param instance
     * @return
     */
    public UiObject findObjectNew(String Type, String Value,int instance){
        /**
         * 定位元素
         * 支持id，text，class，desc
         * 会校验是否存在
         * 验证超时
         * 失败阻断用例实现
        */
        return findUiobject(new Ele[]{new Ele(Type,Value,instance)});
    }

    /**
     * 为监听异常创建的定位方式
     * @param eles
     * @return
     */
    public UiObject findObjectForWathcer(Ele[] eles){
        /**
         * 定位元素
         * 支持id，text，class，desc
         * isAssertExists 为true时同findObjectNew(String Type, String Value)方法
         * isAssertExists 为false时不验证是否存在
         * isAssertExists 为false时不对用例产生阻断
         */
        UiSelector uiSelector = getUiSelector(eles);
        return findUiobject(uiSelector);

    }

    /**
     * 从列表定位元素
     * @param ListViewType
     * @param ListViewValue
     * @param text
     * @return
     */
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
        return target;
    }

    public UiObject findObjectInListView(String ListViewType, String ListViewValue, String childType,String childValue,String text){
        /**
         * 定位元素，从列表中找到指定文本的元素对象
         */
        UiScrollable list =findListViewObject(ListViewType,ListViewValue);
        try {
            UiObject target=null;
            target = findUiobject(new Ele[]{new Ele(childType,childValue),new Ele(Config.TYPE_TEXT,text)});
            if (target.waitForExists(5)){
                return target;
            }
            for(int i=0;i<10;i++){
                list.scrollForward(20);
                if (target.waitForExists(0)){
                    return target;
                }
            }
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        return null;
        /**
         * 当列表翻页请求优化较好时，可以使用如下方法翻页定位
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
            FailedCase.interruptProcess(String.format("get child ,excepet UiObjectNotFoundException with value:%s",text));
        }
        return target;
         **/
    }

    public UiObject findUiobjectInList(EleN[] listobj,EleN[] targetobj){
        UiScrollable list =findListViewObject(listobj);
        try {
            UiObject target=null;
            target = findUiobject(targetobj);
            if (target.waitForExists(5)){
                return target;
            }
            for(int i=0;i<10;i++){
                list.scrollForward(20);
                if (target.waitForExists(0)){
                    return target;
                }
            }
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public UiObject findUiobjectInList(UiSelector listobj,UiSelector targetobj){
        UiScrollable list =findListViewObject(listobj);
        try {
            UiObject target=null;
            target = findUiobject(targetobj);
            if (target.waitForExists(5)){
                return target;
            }
            for(int i=0;i<10;i++){
                list.scrollForward(20);
                if (target.waitForExists(0)){
                    return target;
                }
            }
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        return null;
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

    public UiScrollable findListViewObject(EleN[] eleN){
        UiScrollable list = new UiScrollable(getUiSelector(eleN));
        return list;
    }

    public UiScrollable findListViewObject(UiSelector eleN){
        UiScrollable list = new UiScrollable(eleN);
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
