package com.hnrmb.Page;

import com.hnrmb.Utils.Solo;
/**
 * 我的好物订单页面元素及操作封装
 * 规范：
 * 1、元素定位，以object开头
 * 2、操作，以action开头
 * 3、验证，以assert开头
 */
public class MyGoodsOrder {

    public Solo solo;
    public MyGoodsOrder(Solo so) {
        solo = so;
    }
}
