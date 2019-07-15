package com.heiyu.bilibiliantiadsplatfrom.Controller;

import com.heiyu.bilibiliantiadsplatfrom.Domain.StandardReponse;
import com.heiyu.bilibiliantiadsplatfrom.Domain.Uid;
import com.heiyu.bilibiliantiadsplatfrom.Server.UidServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.List;

@RestController
@RequestMapping(path = "/banneduid")
public class BannedUidController {

    @Autowired
    UidServer uidServer;

    @RequestMapping(method = RequestMethod.GET)
    public StandardReponse<List<Uid>> getBannedUid(){
        return new StandardReponse<List<Uid>>(uidServer.getUidList()) ;
    }

    @RequestMapping(method = RequestMethod.POST)
    public StandardReponse postBannedUid(@RequestBody String string){
        return string+"walala\n";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public StandardReponse deletBannedUid(@RequestBody String string){
        return string;   
    }
}