package com.macrodream.spring.guides.gs.cachinggemfire;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private String type;
    private T value;

    public Result(String type,T value){
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
