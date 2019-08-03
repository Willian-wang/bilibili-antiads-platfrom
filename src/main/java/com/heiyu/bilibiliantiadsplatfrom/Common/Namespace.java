package com.heiyu.bilibiliantiadsplatfrom.Common;

import com.heiyu.bilibiliantiadsplatfrom.Domain.Uid;
import com.heiyu.bilibiliantiadsplatfrom.Domain.UidLog;

/**
 * @ClassName: NameSpace
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 19:37 2019/7/21
 * @Version: 1.0
 **/

public class Namespace {

    public static String getUidNamespace(Uid uid){
        return "uid::"+uid.getSession();
    }
    public static String getUidNamespace(){
        return "uid::common";
    }

    public static String getUidLogNamespace(UidLog uidLog){
        return "uidlog::"+uidLog.getSession();
    }
    public static String getUidLogNamespace(){
        return "uidlog::common";
    }
}
