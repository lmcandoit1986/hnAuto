package com.hnrmb.Page;

import android.graphics.Point;
import android.graphics.Rect;

import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.LogInfo;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.TimeAll;
import com.hnrmb.Utils.UiObjectNew;
/**
 * 登录流程涉及页面元素及操作封装
 *  * 规范：
 *  * 1、元素定位，以object开头
 *  * 2、操作，以action开头
 *  * 3、验证，以assert开头
 */
public class Login {

    public Solo solo;
    public UiObjectNew UN;
    public Login(Solo so){
        solo = so;
        UN = UiObjectNew.getInstance(solo);
    }

    public final String go_login_id = "com.hnrmb.salary:id/tv_login";
    public final String input_phone_id = "com.hnrmb.salary:id/cet_login_name";
    public final String input_psw_id = "com.hnrmb.salary:id/cet_login_pwd";
    public final String login_btn_id = "com.hnrmb.salary:id/login_btn_login";
    public static final String LOCK_ID = "com.hnrmb.salary:id/xguv_gesture";

    private UiObject objectGoLogin(){
        return UN.findObjectNew(Config.TYPE_ID,go_login_id);
    }

    private UiObject objectPhoneEdit(){
        return UN.findObjectNew(Config.TYPE_ID,input_phone_id);
    }

    private UiObject objectPswEdit(){
        return UN.findObjectNew(Config.TYPE_ID,input_psw_id);
    }

    private UiObject objectLogin(){
        return UN.findObjectNew(Config.TYPE_ID,login_btn_id);
    }

    public Login actionGoLogin(){
        Operate.click(objectGoLogin());
        return this;
    }

    public Login actionInputPhone(String Phone){
        Operate.input(objectPhoneEdit(),Phone);
        return this;
    }

    public Login actionInputPsw(String Psw){
        Operate.input(objectPswEdit(),Psw);
        return this;
    }

    public Login actionLogin(){
        Operate.click(objectLogin());
        return this;
    }

    public Main lock(){
        UiObject lock = UN.findObjectNew(Config.TYPE_ID,LOCK_ID);
        Rect rect = null;
        // Rect(188, 668 - 892, 1372)
        try {
            rect =lock.getBounds();
            int left = rect.left;
            int width = rect.width();
            int height = rect.height();
            int top = rect.top;
            LogInfo.i(rect.toString());

            Point p1 = new Point();
            p1.x = left + width/6;
            p1.y = top + height/6;
            Point p2 = new Point();
            p2.x = left + width/6*5;
            p2.y = top + height/6;
            Point p3 = new Point();
            p3.x = left + width/6*5;
            p3.y = top + height/6*5;
            Point[] points = {p1,p2,p3};

            Operate.swipe(solo.getMydevice(),points,30);
            TimeAll.sleepTread(1000);
            Operate.swipe(solo.getMydevice(),points,30);
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        return new Main(solo);
    }

    public Main actionLoginWithPhoneAndPsw(String Phone,String Psw){
        return this.actionGoLogin().actionInputPhone(Phone).actionInputPsw(Psw).actionLogin().lock();
    }

}
