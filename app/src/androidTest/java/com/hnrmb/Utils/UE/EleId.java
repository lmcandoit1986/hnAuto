package com.hnrmb.Utils.UE;

public class EleId extends EleN {
    public EleId(String id){
        this.setId(id);
    }

    public EleId(String id,int instance){
        this.setId(id);
        this.setInstance(instance);
    }

    public EleId(String id,int index,int instance){
        this.setId(id);
        this.setIndex(index);
        this.setInstance(instance);
    }

    public EleId(int index,String id){
        this.setId(id);
        this.setIndex(index);
    }

    public static void main(String[] args){
        EleId eleId = new EleId("testid");
        System.out.print(eleId.getClassName());
        System.out.print(eleId.getId());
    }
}
