package com.hnrmb.Page;

import com.hnrmb.Utils.Solo;
import com.hnrmb.Utils.UiObjectNew;
/**
 * 退出登录涉及页面元素及操作封装
 *  * 规范：
 *  * 1、元素定位，以object开头
 *  * 2、操作，以action开头
 *  * 3、验证，以assert开头
 */
public class Logout {

    public Solo solo;
    public UiObjectNew UN;
    public Logout(Solo so) {
        solo = so;
        UN = UiObjectNew.getInstance(solo);
    }


}
