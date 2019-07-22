package com.heiyu.bilibiliantiadsplatfrom.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.heiyu.bilibiliantiadsplatfrom.Domain.StandardReponse;
import com.heiyu.bilibiliantiadsplatfrom.Domain.Uid;
import com.heiyu.bilibiliantiadsplatfrom.Server.UidServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

import static com.heiyu.bilibiliantiadsplatfrom.Common.IdGenerator.getId;

@RestController
@RequestMapping(path = "/banneduid")
public class BannedUidController {

    @Autowired
    UidServer uidServer;

    @RequestMapping(method = RequestMethod.GET)
    public StandardReponse<Set<Uid>> getBannedUid(@RequestBody Uid uid) throws IOException {
        return new StandardReponse<Set<Uid>>(uidServer.getUidList(uid)) ;
    }

    @RequestMapping(method = RequestMethod.POST)
    public StandardReponse postBannedUid(@RequestBody Uid uid) throws JsonProcessingException {
        uid.setId(getId());
        uidServer.banUid(uid);
        return new StandardReponse("success");
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public StandardReponse deletBannedUid(@RequestBody Uid[] uids){
        uidServer.deletUid(uids);
        return new StandardReponse("success");
    }

}