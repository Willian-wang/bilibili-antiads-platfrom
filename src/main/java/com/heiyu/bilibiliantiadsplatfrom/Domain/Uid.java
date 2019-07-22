package com.heiyu.bilibiliantiadsplatfrom.Domain;

public class Uid extends BasicEntity {
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    private String uid;
    private String session;

}
