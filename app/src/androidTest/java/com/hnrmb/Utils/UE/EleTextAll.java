package com.hnrmb.Utils.UE;

import com.hnrmb.Config.Config;

public class EleTextAll extends EleN{

    public EleTextAll(int type,String id){
        switch (type){
            case Config.TEXT_MTACH:
                this.setTextMatch(id);
                break;
            case Config.TEXT_CONTAIN:
                this.setTextContain(id);
                break;
            case Config.TEXT_STARTWITH:
                this.setTextStartWith(id);
                break;
            default:
                this.setText(id);
                break;
        }

    }

    public EleTextAll(int type,String id,int index,int instance){
        switch (type){
            case Config.TEXT_MTACH:
                this.setTextMatch(id);
                break;
            case Config.TEXT_CONTAIN:
                this.setTextContain(id);
                break;
            case Config.TEXT_STARTWITH:
                this.setTextStartWith(id);
                break;
            default:
                this.setText(id);
                break;
        }
        this.setIndex(index);
        this.setInstance(instance);

    }

    public EleTextAll(int type,String id,int index){
        switch (type){
            case Config.TEXT_MTACH:
                this.setTextMatch(id);
                break;
            case Config.TEXT_CONTAIN:
                this.setTextContain(id);
                break;
            case Config.TEXT_STARTWITH:
                this.setTextStartWith(id);
                break;
            default:
                this.setText(id);
                break;
        }
        this.setIndex(index);

    }

    public EleTextAll(int type,int instance,String id,int index){
        switch (type){
            case Config.TEXT_MTACH:
                this.setTextMatch(id);
                break;
            case Config.TEXT_CONTAIN:
                this.setTextContain(id);
                break;
            case Config.TEXT_STARTWITH:
                this.setTextStartWith(id);
                break;
            default:
                this.setText(id);
                break;
        }
        this.setInstance(instance);

    }

}
