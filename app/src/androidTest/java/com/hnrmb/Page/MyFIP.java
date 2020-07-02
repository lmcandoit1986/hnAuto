package com.hnrmb.Page;

import android.graphics.Path;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.BySelector;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiSelector;

import com.hnrmb.Utils.DataInfo;
import com.hnrmb.Utils.FailedCase;
import com.hnrmb.Utils.LogInfo;
import com.hnrmb.Utils.MathsObj;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Selector;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.TimeAll;
import com.hnrmb.Utils.UE.EleClass;
import com.hnrmb.Utils.UE.EleId;
import com.hnrmb.Utils.UE.EleN;
import com.hnrmb.Utils.UE.EleText;
import com.hnrmb.Utils.UiObjectNew;

import java.text.DecimalFormat;
import java.util.List;
/**
 * 我的理财页面元素及操作封装
 * 规范：
 * 1、元素定位，以object开头
 * 2、操作，以action开头
 * 3、验证，以assert开头
 */
public class MyFIP {
    public Solo solo;
    public UiObjectNew UN;
    public MyFIP(Solo solo) {
        this.solo = solo;
        UN = UiObjectNew.getInstance(solo);
        long end = DataInfo.getTime() +5;
        while (true){
            if (MathsObj.assertInt(Operate.getText(objectAmount()))){
                break;
            }
            if(DataInfo.getTime() > end){
                LogInfo.w("超5秒，页面加载未完成");
                break;
            }
        }
    }

    private final String amount_id = "com.hnrmb.salary:id/tv_financing"; // 持有资产
    private final String pre_incoming = "com.hnrmb.salary:id/tv_pending_income"; // 待结收益
    private final String rel_incoming = "com.hnrmb.salary:id/tv_received_income"; // 已获收益
    private final String account_entry = "com.hnrmb.salary:id/lay_to_lcb_account_item"; // 理财账户入口
    private final String fip_name_id = "com.hnrmb.salary:id/tv_name";// 持有资产列表-理财名称
    private final String tag = "com.hnrmb.salary:id/tv_tag";// 持有资产列表-状态
    private final String pre_incoming_list_id = "com.hnrmb.salary:id/tv_one_data";// 持有资产列表-预期收益
    private final String amount_list_id = "com.hnrmb.salary:id/tv_two_data";// 持有资产列表-投入金额
    private final String day_list_id ="com.hnrmb.salary:id/tv_three_data";// 持有资产列表-理财期限
    private final String list_class = "android.widget.ListView";// 列表
    private final String history_list_id = "com.hnrmb.salary:id/tv_to_history";// 历史资产入口
    private final String detail = "持有资产(元)";

    private UiObject objectAmount(){return UN.findUiobject(new EleN[]{new EleId(amount_id)});}
    private UiObject objectPreIncoming(){return UN.findUiobject(new EleN[]{new EleId(pre_incoming)});}
    private UiObject objectRelIncoming(){return UN.findUiobject(new EleN[]{new EleId(rel_incoming)});}
    private UiObject objectAccount(){return UN.findUiobject(new EleN[]{new EleId(account_entry)});}
    private UiObject objectHistory(){return UN.findUiobject(new EleN[]{new EleId(history_list_id)});}
    private UiObject objectFipByName(String Name){return UN.findUiobjectInList(new EleN[]{new EleClass(list_class)},new EleN[]{new EleId(fip_name_id),new EleText(Name)});}
    private UiObject objectFipByInstance(int Name){return UN.findUiobjectInList(new EleN[]{new EleClass(list_class)},new EleN[]{new EleId(fip_name_id,Name)});}
    private UiObject2 objectFipAmountByFipName(String Name){return UN.findUiobject2ByParent(By.text(Name).res(fip_name_id),By.res(amount_list_id)); }
    private UiObject2 objectPreIncomingByFipName(String Name){return UN.findUiobject2ByParent(By.text(Name).res(fip_name_id),By.res(pre_incoming_list_id)); }
    private UiObject objectTagByFipName(String Name){return UN.findUiobject(Selector.text(Name).resourceId(fip_name_id),Selector.resourceId(tag)); }
    private UiObject2 objectDayByFipName(String Name){return UN.findUiobject2ByParent(By.text(Name).res(fip_name_id),2,By.res(day_list_id)); }

    public MyFIP assertAmount(){
        LogInfo.i("验证持有资产");
        if(!MathsObj.assertInt(Operate.getText(objectAmount()))) FailedCase.interruptProcess("持有资产不符合预期，"+Operate.getText(objectAmount()),DataInfo.getDayFormatForIMG());
        return this;
    }

    public MyFIP assertPreIncoming(){
        LogInfo.i("验证待结收益");
        if(!MathsObj.assertInt(Operate.getText(objectPreIncoming()))) FailedCase.interruptProcess("待结收益不符合预期，"+Operate.getText(objectPreIncoming()),DataInfo.getDayFormatForIMG());
        return this;
    }

    public MyFIP assertRelIncoming(){
        LogInfo.i("验证已获收益");
        if(!MathsObj.assertInt(Operate.getText(objectRelIncoming()))) FailedCase.interruptProcess("已获收益不符合预期，"+Operate.getText(objectRelIncoming()),DataInfo.getDayFormatForIMG());
        return this;
    }

    public CiticAcount actionIntCiticAcount(){
        LogInfo.i("进入中信-电子账号页面");
        Operate.click(objectAccount());
        return new CiticAcount(solo);
    }

    public FIPTradeDetail actionIntoFIPTradeDetail(String FIPName){
        LogInfo.i("进入理财交易详情-"+FIPName);
        Operate.click(objectFipByName(FIPName));
        return new FIPTradeDetail(solo,FIPName);
    }

    public FIPHistoryOrder actionIntoHistoryList(){
        LogInfo.i("进入历史资产列表");
        Operate.click(objectHistory());
        return new FIPHistoryOrder(solo);
    }

    public MyFIP assertMyFIPDetail(){
        Operate.click(UN.findUiobject(Selector.text(detail)));
        Operate.assertWaitForExists(UN.findUiobject(Selector.text("持有资产中不包含“待付款”状态的产品金额")),5);
        Operate.click(UN.findUiobject(Selector.text("知道了").resourceId("com.hnrmb.salary:id/btn_single_confirm")));
        return this;
    }

    public MyFIP assertTag(String FIP,String tag){
        String rel = Operate.getText(objectTagByFipName(FIP));
        if(!rel.equals(tag)) FailedCase.interruptProcess("标签不符合预期，预期："+tag+ ",实际:"+rel,DataInfo.getDayFormatForIMG());
        return this;
    }

    public MyFIP assertDay(String FIP,String tag){
        String rel = Operate.getText(objectDayByFipName(FIP));
        if(!rel.equals(tag)) FailedCase.interruptProcess("理财期限不符合预期，预期："+tag+ ",实际:"+rel,DataInfo.getDayFormatForIMG());
        return this;
    }

    public MyFIP assertMoney(String FIP, int day, double rate){
        String amount_s = Operate.getText(objectFipAmountByFipName(FIP)).replace(",","");
        String profit_s = Operate.getText(objectPreIncomingByFipName(FIP)).replace(",","");
        float amount = Float.parseFloat(amount_s);
        if (!String.format("%.2f", amount*rate/100*day/365).equals(profit_s)) FailedCase.interruptProcess("预期收益:"+String.format("%.2f", amount*rate/100*day/365)+",实际:"+profit_s,DataInfo.getDayFormatForIMG());
        return this;
    }





}
