package com.hnrmb.Utils;

import androidx.test.uiautomator.UiSelector;

public class Selector {

    public static UiSelector resourceId(String idString){
        return new UiSelector().resourceId(idString);
    }

    public static UiSelector resourceId(String idString,int instance){
        return new UiSelector().resourceId(idString).instance(instance);
    }

    public static UiSelector resourceId(int index,String idString){
        return new UiSelector().resourceId(idString).index(index);
    }

    public static UiSelector text(String idString){
        return new UiSelector().text(idString);
    }

    public static UiSelector text(String idString,int instance){
        return new UiSelector().text(idString).instance(instance);
    }

    public static UiSelector text(int index,String idString){
        return new UiSelector().text(idString).index(index);
    }

    public static UiSelector className(String idString){
        return new UiSelector().className(idString);
    }

    public static UiSelector className(String idString,int instance){
        return new UiSelector().className(idString).instance(instance);
    }

    public static UiSelector className(int index,String idString){
        return new UiSelector().className(idString).index(index);
    }

    public static UiSelector desc(String idString){
        return new UiSelector().description(idString);
    }

    public static UiSelector desc(String idString,int instance){
        return new UiSelector().description(idString).instance(instance);
    }

    public static UiSelector desc(int index,String idString){
        return new UiSelector().description(idString).index(index);
    }

    public static UiSelector textStartWith(String idString){
        return new UiSelector().textStartsWith(idString);
    }

    public static UiSelector textStartWith(String idString,int instance){
        return new UiSelector().textStartsWith(idString).instance(instance);
    }

    public static UiSelector textStartWith(int index,String idString){
        return new UiSelector().textStartsWith(idString).index(index);
    }

    public static UiSelector textMatch(String idString){
        return new UiSelector().textMatches(idString);
    }

    public static UiSelector textMatch(String idString,int instance){
        return new UiSelector().textMatches(idString).instance(instance);
    }

    public static UiSelector textMatch(int index,String idString){
        return new UiSelector().textMatches(idString).index(index);
    }

    public static UiSelector textContains(String idString){
        return new UiSelector().textContains(idString);
    }

    public static UiSelector textContains(String idString,int instance){
        return new UiSelector().textContains(idString).instance(instance);
    }

    public static UiSelector textContains(int index,String idString){
        return new UiSelector().textContains(idString).index(index);
    }

    public static UiSelector index(int index){
        return new UiSelector().index(index);
    }

    public static UiSelector instance(int index){
        return new UiSelector().instance(index);
    }




}
