package com.hnrmb.Utils;

public class MathsObj {

    public static Boolean assertInt(String IntStr){
        IntStr = IntStr.replace(",","");
        try {
            Float.parseFloat(IntStr);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        assertInt("123.00");
        assertInt("0.00");
        assertInt("11,111.00");
        assertInt("a123");

    }

}
