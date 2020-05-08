package com.hnrmb.Page;

import androidx.test.uiautomator.UiObject;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;
/**
 * 个人中心页面元素及操作封装
 * 规范：
 * 1、元素定位，以object开头
 * 2、操作，以action开头
 * 3、验证，以assert开头
 */
public class Personal {

    public Solo solo;
    public UiObjectNew UN;
    public Personal(Solo so){
        solo = so;
        UN = UiObjectNew.getInstance(solo);
    }

    private final String logout_btn_id = "com.hnrmb.salary:id/tv_quit";
    private final String myinfo_id = "com.hnrmb.salary:id/lay_my_info";
    private final String mybank_id = "com.hnrmb.salary:id/lay_my_bank";
    private final String myadress_id = "com.hnrmb.salary:id/lay_my_address";
    private final String mycontacts_id = "com.hnrmb.salary:id/lay_my_contacts";
    private final String myauth_state_id = "com.hnrmb.salary:id/tv_name_auth_state";
    private final String myphone_id = "com.hnrmb.salary:id/tv_my_phone";
    private final String mywhchat_id = "com.hnrmb.salary:id/tv_my_wechat";
    private final String mysecurity_id = "com.hnrmb.salary:id/lay_security";
    private final String about_id = "com.hnrmb.salary:id/realtive_about";

    // 退出按钮
    private UiObject objectLogout(){
        return UN.findObjectNew(Config.TYPE_ID,logout_btn_id);
    }
    // 我的信息
    private UiObject objectMyInfo(){
        return UN.findObjectNew(Config.TYPE_ID,myinfo_id);
    }
    // 我的绑卡
    private UiObject objectMybank(){
        return UN.findObjectNew(Config.TYPE_ID,mybank_id);
    }
    // 我的收获地址
    private UiObject objectMyAddress(){
        return UN.findObjectNew(Config.TYPE_ID,myadress_id);
    }
    // 我的联系人
    private UiObject objectMyContacts(){
        return UN.findObjectNew(Config.TYPE_ID,mycontacts_id);
    }
    // 我的实名认证
    private UiObject objectMyAuth(){
        return UN.findObjectNew(Config.TYPE_ID,myauth_state_id);
    }
    // 我的绑定手机
    private UiObject objectMyPhone(){
        return UN.findObjectNew(Config.TYPE_ID,myphone_id);
    }
    // 我的微信
    private UiObject objectMyWechat(){
        return UN.findObjectNew(Config.TYPE_ID,mywhchat_id);
    }
    // 安全认证
    private UiObject objectSecrity(){
        return UN.findObjectNew(Config.TYPE_ID,mysecurity_id);
    }
    // 关于
    private UiObject objectAbout(){
        return UN.findObjectNew(Config.TYPE_ID,about_id);
    }

    // 点击退出登录按钮
    public Logout actionGoLogout(){
        Operate.click(objectLogout());
        return new Logout(solo);
    }

}
