package com.heiyu.bilibiliantiadsplatfrom.Domain;

import com.heiyu.bilibiliantiadsplatfrom.Common.IdGenerator;

import java.sql.Timestamp;

/**
 * @ClassName: UidLog
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 15:18 2019/8/3
 * @Version: 1.0
 **/

public class UidLog extends BasicEntity {
    private String uid;
    private String action;
    private String session;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String sessionId) {
        this.session = sessionId;
    }

    public static UidLog uid2UidLog(Uid uid,String action){
        UidLog uidLog = new UidLog();
        if(action.equals("insert")){
            uidLog.setId(uid.getId());
            uidLog.setUpdateTime(uid.getUpdateTime());
        }else if(action.equals("delete")){
            uidLog.setId(IdGenerator.getId());
            uidLog.setUpdateTime( new Timestamp (System.currentTimeMillis()));
        }

        uidLog.setCreateTime(uid.getCreateTime());
        uidLog.setSession(uid.getSession());
        uidLog.setUid(uid.getUid());
        return uidLog;
    }
}
