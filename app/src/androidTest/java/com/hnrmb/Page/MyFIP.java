package com.hnrmb.Page;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.BySelector;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiSelector;

import com.hnrmb.Utils.DataInfo;
import com.hnrmb.Utils.LogInfo;
import com.hnrmb.Utils.MathsObj;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.TimeAll;
import com.hnrmb.Utils.UE.EleClass;
import com.hnrmb.Utils.UE.EleId;
import com.hnrmb.Utils.UE.EleN;
import com.hnrmb.Utils.UE.EleText;
import com.hnrmb.Utils.UiObjectNew;

import java.util.List;

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

    private UiObject objectAmount(){return UN.findUiobject(new EleN[]{new EleId(amount_id)});}
    private UiObject objectPreIncoming(){return UN.findUiobject(new EleN[]{new EleId(pre_incoming)});}
    private UiObject objectRelIncoming(){return UN.findUiobject(new EleN[]{new EleId(rel_incoming)});}
    private UiObject objectAccount(){return UN.findUiobject(new EleN[]{new EleId(account_entry)});}
    private UiObject objectFipByName(String Name){return UN.findUiobjectInList(new EleN[]{new EleClass(list_class)},new EleN[]{new EleId(fip_name_id),new EleText(Name)});}
    private UiObject objectFipByInstance(int Name){return UN.findUiobjectInList(new EleN[]{new EleClass(list_class)},new EleN[]{new EleId(fip_name_id,Name)});}
    private UiObject2 objectFipAmountByFipName(String Name){return UN.findUiobject2ByParent(By.text(Name).res(fip_name_id),2,By.res(amount_list_id)); }
    private UiObject2 objectPreIncomingByFipName(String Name){return UN.findUiobject2ByParent(By.text(Name).res(fip_name_id),2,By.res(pre_incoming_list_id)); }
    private UiObject2 objectTagByFipName(String Name){return UN.findUiobject2ByParent(By.text(Name).res(fip_name_id),2,By.res(tag)); }
    private UiObject2 objectDayByFipName(String Name){return UN.findUiobject2ByParent(By.text(Name).res(fip_name_id),2,By.res(day_list_id)); }





}
