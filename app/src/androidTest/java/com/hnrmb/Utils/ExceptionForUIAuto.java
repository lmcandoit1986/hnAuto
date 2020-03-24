package com.hnrmb.Utils;

/**
 * Created by liming on 2020/3/24.
 */

/**
 * 新建异常类型，主要处理抛出异常后，日志以及截图等的操作
 */

public class ExceptionForUIAuto extends Exception {

    public ExceptionForUIAuto(String msg) {
        super(msg);
    }

    public ExceptionForUIAuto(String msg, String pic_name) {
        super(msg);
        new Pic().screenShotWithADB(pic_name);
        System.out.print(pic_name);
    }


    public static void main(String[] args) throws ExceptionForUIAuto {
        System.out.print("qwqfhqfihqofhi\n");
        throw new ExceptionForUIAuto("messageError","asdasfasf");
    }
}
