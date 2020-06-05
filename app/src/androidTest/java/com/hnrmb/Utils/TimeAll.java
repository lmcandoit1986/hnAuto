package com.hnrmb.Utils;

/**
 * Created by liming on 2020/3/24.
 */

public class TimeAll {

    public static void sleepTread(long l){
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
        Ele e = new Ele("id","123");

        Ele[] elist = new Ele[1];
        elist[0] = e;

        findUiobject(elist);

    }


}
