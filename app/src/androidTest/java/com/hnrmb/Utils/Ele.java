package com.hnrmb.Utils;

public class Ele {
    private String Type;
    private String Value;
    private int Index;
    private int Instance;

    public Ele(String Type,int Index,String Value,int Instance){
        this.Type = Type;
        this.Value = Value;
        this.Index = Index;
        this.Instance = Instance;
    }

    public Ele(String Type,String Value,int Instance){
        this.Type = Type;
        this.Value = Value;
        this.Index = -1;
        this.Instance = Instance;
    }

    public Ele(String Type,int Index,String Value){
        this.Type = Type;
        this.Value = Value;
        this.Index = Index;
        this.Instance = -1;
    }

    public Ele(String Type,String Value){
        this.Type = Type;
        this.Value = Value;
        this.Index = -1;
        this.Instance = -1;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public int getIndex() {
        return Index;
    }

    public void setIndex(int index) {
        Index = index;
    }

    public int getInstance() {
        return Instance;
    }

    public void setInstance(int instance) {
        Instance = instance;
    }

    public String about(){
        return String.format("Detail Type:%s,Value:%s,index:%d,instance:%d",getType(),getValue(),getIndex(),getInstance());
    }
}
