package com.heiyu.bilibiliantiadsplatfrom.Common;

import com.heiyu.bilibiliantiadsplatfrom.Domain.Uid;

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

}
