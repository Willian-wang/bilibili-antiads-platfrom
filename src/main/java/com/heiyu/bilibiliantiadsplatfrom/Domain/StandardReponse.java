package com.heiyu.bilibiliantiadsplatfrom.Domain;

import java.util.HashMap;

public class StandardReponse<T> {
    private int reponseCode;
    private String responseInf;
    private T Data;

    public StandardReponse(T t){
        this.Data = t;
    }

    public int getReponseCode() {
        return reponseCode;
    }

    public void setReponseCode(int reponseCode) {
        this.reponseCode = reponseCode;
    }

    public String getResponseInf() {
        return responseInf;
    }

    public void setResponseInf(String responseInf) {
        this.responseInf = responseInf;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    static final HashMap<Integer,String> map = new HashMap<>(){{
        map.put(10000,"OK");
        map.put(20000,"Not authority");
        map.put(30000,"Request is too quick");
        map.put(40000,"Not found");
        map.put(50000,"ServerError");
    }

    };


}
