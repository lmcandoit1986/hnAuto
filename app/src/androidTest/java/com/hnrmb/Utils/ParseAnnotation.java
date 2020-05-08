package com.hnrmb.Utils;

import androidx.test.uiautomator.UiObject;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ParseAnnotation {

    /**
     * 解析方法注解
     * @param <T>
     * @param clazz
     */
    public static <T> UiObject parseMethod(Class<T> clazz,Solo solo) {
        try {
            T obj = clazz.newInstance();
            for (Field field : clazz.getDeclaredFields()){
                ObjectDec methodAnnotation = field.getAnnotation(ObjectDec.class);
                if (methodAnnotation!=null) {
                    //通过反射调用带有此注解的方法
                    String type = methodAnnotation.type();
                    String value = methodAnnotation.value();
                    int instance = methodAnnotation.instance();
                    LogInfo.i(String.format("%s:%s:%d",type,value,instance));
                    return UiObjectNew.getInstance(solo).findObjectNew(type,value,instance);
                }

            }

//            for (Method method : clazz.getDeclaredMethods()) {
//                ObjectDec methodAnnotation = method.getAnnotation(ObjectDec.class);
//                if (methodAnnotation!=null) {
//                    //通过反射调用带有此注解的方法
//                    String type = methodAnnotation.type();
//                    String value = methodAnnotation.value();
//                    int instance = methodAnnotation.instance();
//
//                    return new UiObjectNew().findObjectNew(type,value,instance);
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析类注解
     * @param
     * @param
     */
//    public static <T> void parseType(Class<T> clazz) {
//        try {
//            Yts yts = (Yts) clazz.getAnnotation(Yts.class);
//            if (yts != null) {
//                if (YtsType.util.equals(yts.classType())) {
//                    System.out.println("this is a util class");
//                } else {
//                    System.out.println("this is a other class");
//                }
//            }
//            MyClassAnnotation classAnnotation = (MyClassAnnotation) clazz.getAnnotation(MyClassAnnotation.class);
//            if (classAnnotation != null) {
//                System.err.println(" class info: "+classAnnotation.uri());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
//        parseMethod(TestAnnotation.class);
//        parseType(TestAnnotation.class);
    }


}
