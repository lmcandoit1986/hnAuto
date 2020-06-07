package com.hnrmb.Utils.UE;

public class EleDesc extends EleN{
    public EleDesc(String id){
        this.setDesc(id);
    }

    public EleDesc(String id,int instance){
        this.setDesc(id);
        this.setInstance(instance);
    }

    public EleDesc(String id,int index,int instance){
        this.setDesc(id);
        this.setIndex(index);
        this.setInstance(instance);
    }

    public EleDesc(int index,String id){
        this.setDesc(id);
        this.setIndex(index);
    }
}
