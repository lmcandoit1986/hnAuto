package com.hnrmb.Page;

import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;

import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;

import com.hnrmb.Config.Config;
import com.hnrmb.Server.PageAPI.LoginAPI;
import com.hnrmb.Utils.Ele;
import com.hnrmb.Utils.LogInfo;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Selector;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.TimeAll;
import com.hnrmb.Utils.UE.EleId;
import com.hnrmb.Utils.UE.EleN;
import com.hnrmb.Utils.UE.EleText;
import com.hnrmb.Utils.UiObjectNew;

import org.json.JSONObject;

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
    public final String LOCK_ID = "com.hnrmb.salary:id/xguv_gesture";
    public final String CHANGE_ANOTHER_USER = "com.hnrmb.salary:id/tv_login_gesture_otherlogin";
    public final String phoneSuggestion = "android:id/autofill_dataset_picker";
    public final String phoneSuggestion_1 = "com.miui.contentcatcher:id/auto_fill_data_name";

    private UiObject objectGoLogin(){
        return UN.findUiobject(new Ele[]{new Ele(Config.TYPE_ID,go_login_id)});
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

    private UiObject objectChangeUser(){
        return UN.findUiobject(new EleN[]{new EleId(CHANGE_ANOTHER_USER)});
    }

    public Login actionGoLogin(){
        Operate.click(objectGoLogin(),true);
        return this;
    }

    public Login actionInputPhone(String Phone){
        if(Operate.assertWaitForExists(UN.findUiobject(Selector.resourceId(phoneSuggestion)),2,false)) Operate.click(UN.findUiobject(Selector.resourceId(phoneSuggestion_1)));
        Operate.input(objectPhoneEdit(),Phone);
        return this;
    }

    public Login actionChangeUser(){
        Operate.clickAndWaitForNewWindow(objectChangeUser());
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

    public Login actionPhoneCode(String Phone){
        if (Config.ENV.equals("rel")) return this;
        if (!Operate.assertWaitForExists(UN.findUiobject(Selector.resourceId("com.hnrmb.salary:id/underline_lay")),2,false)) return this;
        String Code = LoginAPI.del_login_log(Phone);
        Operate.input(UN.findUiobject(Selector.resourceId("com.hnrmb.salary:id/underline_lay")),Code);
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
            TimeAll.sleepTread(1500);
            if (Operate.assertWaitForExists(UN.findUiobject(new EleN[]{new EleText("再次绘制手势密码")}),15,false)){
                Operate.swipe(solo.getMydevice(),points,30);
            }else{
                LogInfo.e("绘制图案解锁失败");
                Operate.swipe(solo.getMydevice(),points,30);
            }

        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        return new Main(solo);
    }

    public Main actionLoginWithPhoneAndPsw(String Phone,String Psw){
//        LoginAPI.del_login_log(Phone);
        if (!Operate.assertWaitForExists(UN.findUiobject(new Ele[]{new Ele(Config.TYPE_TEXT,"切换其他账户")}),5,false)){
            return this.actionGoLogin().actionInputPhone(Phone).actionInputPsw(Psw).actionLogin().actionPhoneCode(Phone).lock();
        }
        return Other.unlock(solo,Phone,Psw);

    }

    public Main actionReloginWithPhoneAndPsw(String Phone,String Psw){
        // 有登录账户的场景
        if(Operate.assertWaitForExists(UN.findUiobject(new Ele[]{new Ele(Config.TYPE_TEXT,"切换其他账户")}),3,false)){
            if(!Operate.assertWaitForExists(UN.findUiobject(new EleN[]{new EleText(Phone.replaceAll(Phone.substring(3,Phone.length()-4),"****"))}),1,false)) {
//                LoginAPI.del_login_log(Phone);
               return this.actionChangeUser().actionInputPhone(Phone).actionInputPsw(Psw).actionLogin().actionPhoneCode(Phone).lock();
            }
            return Other.unlock(solo,Phone,Psw);

        }
        // 无账号登录的场景
        if (Operate.assertWaitForExists(objectGoLogin(),3,false)){
//            LoginAPI.del_login_log(Phone);
           return this.actionGoLogin().actionInputPhone(Phone).actionInputPsw(Psw).actionLogin().actionPhoneCode(Phone).lock();
        }
        // 有账号登录且在主页面的场景
//        LoginAPI.del_login_log(Phone);
        return new Main(solo,Phone,Psw).actionIntoMy().actionGoPersonal().Logout().actionGoLogin().actionInputPhone(Phone).actionInputPsw(Psw).actionLogin().actionPhoneCode(Phone).lock();

    }

}
