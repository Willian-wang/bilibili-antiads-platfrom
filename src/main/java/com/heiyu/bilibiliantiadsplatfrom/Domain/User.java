package com.heiyu.bilibiliantiadsplatfrom.Domain;

import java.sql.Timestamp;

/**
 * @ClassName: User
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 15:34 2019/7/20
 * @Version: 1.0
 **/

public class User extends BasicEntity {

    private String userName;
    private String password;
    private String session;
    private byte privilege;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public byte getPrivilege() {
        return privilege;
    }

    public void setPrivilege(byte privilege) {
        this.privilege = privilege;
    }
}
