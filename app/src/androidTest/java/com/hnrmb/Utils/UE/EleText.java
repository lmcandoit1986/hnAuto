package com.hnrmb.Utils.UE;

public class EleText extends EleN{

    public EleText(String id){
        this.setText(id);
    }

    public EleText(String id,int instance){
        this.setText(id);
        this.setInstance(instance);
    }

    public EleText(String id,int index,int instance){
        this.setText(id);
        this.setIndex(index);
        this.setInstance(instance);
    }

    public EleText(int index,String id){
        this.setText(id);
        this.setIndex(index);
    }
}
