package com.hnrmb.Utils.UE;

import com.hnrmb.Utils.Ele;

public class EleN {
    private String className=null;
    private String text=null;
    private String desc=null;
    private int index=-99;
    private int instance=-99;
    private String textContain=null;
    private String textMatch=null;
    private String textStartWith=null;
    private String id=null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getInstance() {
        return instance;
    }

    public void setInstance(int instance) {
        this.instance = instance;
    }

    public String getTextContain() {
        return textContain;
    }

    public void setTextContain(String textContain) {
        this.textContain = textContain;
    }

    public String getTextMatch() {
        return textMatch;
    }

    public void setTextMatch(String textMatch) {
        this.textMatch = textMatch;
    }

    public String getTextStartWith() {
        return textStartWith;
    }

    public void setTextStartWith(String textStartWith) {
        this.textStartWith = textStartWith;
    }

    public static void main(String[] args){
//        EleN eleN = new EleN("");
    }
}
