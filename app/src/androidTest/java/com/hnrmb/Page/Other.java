package com.hnrmb.Page;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;

import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;

import com.hnrmb.Config.Config;
import com.hnrmb.Data.Unlock;
import com.hnrmb.Utils.LogInfo;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Selector;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;

import java.lang.ref.PhantomReference;

/**
 * 主页面元素及操作封装
 * 规范：
 * 1、元素定位，以object开头
 * 2、操作，以action开头
 * 3、验证，以assert开头
 */
public class Other {

    public static final String CLOSE_UPDATE_ID= "com.hnrmb.salary:id/linear_close";//升级弹框关闭按钮
    public static final String LOCK_ID = "com.hnrmb.salary:id/xguv_gesture";

    public static void closeUpdate(Solo solo){
        // 升级弹框关闭
        Operate.click(UiObjectNew.getInstance(solo).findObjectNew(Config.TYPE_ID,CLOSE_UPDATE_ID),false);
        // 不中断测试
    }

    public static Main unlock(Solo solo,String User,String Psw){
        // 解锁-固定点，适用固定屏幕尺寸
//        Operate.swipe(solo.getMydevice(), Unlock.getLockTrail(solo.getPhoneWidth(), solo.getPhoneHeight()),30);

        // 解锁，换算百分比
        UiObject lock = UiObjectNew.getInstance(solo).findObjectNew(Config.TYPE_ID,LOCK_ID);
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
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }

        if(Operate.assertWaitForExists(UiObjectNew.getInstance(solo).findUiobject(Selector.text("你得先登录才能操作，请重新登录")),3,false)){
            Operate.click(UiObjectNew.getInstance(solo).findUiobject(Selector.resourceId("com.hnrmb.salary:id/btn_single_confirm")));
            new Login(solo).actionReloginWithPhoneAndPsw(User,Psw);
        }
        return new Main(solo,User,Psw);
    }

    /**
     * 获取版本号
     *
     * @param context 上下文
     *
     * @return 版本号
     */
    public static int getVersionCode(Context context) {

        //获取包管理器
        PackageManager pm = context.getPackageManager();
        //获取包信息
        try {
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            //返回版本号
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return 0;

    }



}
