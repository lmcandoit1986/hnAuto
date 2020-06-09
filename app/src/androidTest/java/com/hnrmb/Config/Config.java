package com.hnrmb.Config;

public class Config {

    public static final String TYPE_ID = "id";
    public static final String TYPE_CLASS = "class";
    public static final String TYPE_TEXT = "text";
    public static final String TYPE_TEXT_1 = "text_match";
    public static final String TYPE_TEXT_3 = "text_contain";
    public static final String TYPE_TEXT_2 = "text_startwith";
    public static final String TYPE_DESC = "desc";

    public static final String UP = "up";
    public static final String DOWN = "down";
    public static final String LEFT = "left";
    public static final String RIGHT = "right";

    public static String ToastMSG;

    public static final String ENV = "rel"; // rel ,test

    public static final Boolean Debug = false; // true 时走app 启动等流程

    public static final int TEXT_MTACH = 0;
    public static final int TEXT_CONTAIN = 1;
    public static final int TEXT_STARTWITH = 2;

}
