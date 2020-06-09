package com.hnrmb.Page;

import com.hnrmb.Config.Config;
import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;

/**
 * Webview页面基础
 *  * 规范：
 *  * 1、元素定位，以object开头
 *  * 2、操作，以action开头
 *  * 3、验证，以assert开头
 */
public class Webview {

    public Solo solo;
    public UiObjectNew UN;
    public Webview(Solo so){
        solo = so;
        UN = UiObjectNew.getInstance(so);
    }

    public final String WEB_CLASS = "android.webkit.WebView";

    public Webview assertIsWeb(){
        UN.findObjectNew(Config.TYPE_CLASS,WEB_CLASS);
        return this;
    }


}
