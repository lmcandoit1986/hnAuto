package com.hnrmb.Page;

import androidx.test.uiautomator.UiObject;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.FailedCase;
import com.hnrmb.Utils.Operate;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;
/**
 * 公益页面元素及操作封装
 * 规范：
 * 1、元素定位，以object开头
 * 2、操作，以action开头
 * 3、验证，以assert开头
 */
public class publicWork {

    public Solo solo;
    public UiObjectNew UN;
    public publicWork(Solo so) {
        solo = so;
        UN = UiObjectNew.getInstance(so);
    }

    public final String title_id = "com.hnrmb.salary:id/head_content_tv";

    public UiObject objectTitle(){
        return UN.findObjectNew(Config.TYPE_ID,title_id);
    }

    public String getTitle(){
        return Operate.getText(objectTitle());
    }


    public publicWork assertNomal(){
        String title = getTitle();
        if (!title.equals("扶贫公益"))
            FailedCase.interruptProcess(String.format("标题预期:扶贫公益,实际:%s",title));
        return this;
    }

}
