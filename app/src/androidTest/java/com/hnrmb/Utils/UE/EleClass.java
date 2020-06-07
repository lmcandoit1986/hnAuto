package com.hnrmb.Utils.UE;

public class EleClass extends EleN{
    public EleClass(String id){
        this.setClassName(id);
    }

    public EleClass(String id,int instance){
        this.setClassName(id);
        this.setInstance(instance);
    }

    public EleClass(String id,int index,int instance){
        this.setClassName(id);
        this.setIndex(index);
        this.setInstance(instance);
    }

    public EleClass(int index,String id){
        this.setClassName(id);
        this.setIndex(index);
    }
}
