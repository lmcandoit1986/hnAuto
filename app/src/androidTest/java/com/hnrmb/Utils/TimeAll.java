package com.hnrmb.Utils;

/**
 * Created by liming on 2020/3/24.
 */

public class TimeAll {

    public static void sleepTread(int l){
        LogInfo.i("sleep "+l);
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void findUiobject(Ele[] eleList){
        for(Ele e : eleList){
            System.out.print(e.getIndex());
            e.getInstance();
            e.getType();
            e.getValue();
        }
    }

    public static void main(String[] args){
        //定义的字符串
        String s = "15801689735";
//        通过length方法获取字符串长度
        for (int i = 0;i < s.length();i++){
            //charAt是获取字符串第i个字符
            System.out.println(s.charAt(i));
        }

        String a = s.replaceAll(s.substring(7,s.length()),"");
        System.out.println(a);

        System.out.println(s.substring(3,s.length()-4));

    }


}
