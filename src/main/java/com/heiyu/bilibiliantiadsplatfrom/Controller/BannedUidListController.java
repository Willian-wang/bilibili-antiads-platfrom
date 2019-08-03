package com.heiyu.bilibiliantiadsplatfrom.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.heiyu.bilibiliantiadsplatfrom.Domain.StandardReponse;
import com.heiyu.bilibiliantiadsplatfrom.Domain.Uid;
import com.heiyu.bilibiliantiadsplatfrom.Domain.UidVO;
import com.heiyu.bilibiliantiadsplatfrom.Service.UidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Set;

import static com.heiyu.bilibiliantiadsplatfrom.Common.IdGenerator.getId;

@RestController
@RequestMapping(path = "/banneduidlist")
public class BannedUidListController {

    @Autowired
    UidService uidService;

    @RequestMapping(method = RequestMethod.GET)
    public StandardReponse<Set<UidVO>> getBannedUid(@RequestBody Uid uid) throws IOException {
        return new StandardReponse<Set<UidVO>>(uidService.getUidList(uid)) ;
    }

    @RequestMapping(method = RequestMethod.POST)
    public StandardReponse postBannedUid(@RequestBody Uid uid) throws JsonProcessingException {

        uidService.banUid(uid);
        return new StandardReponse("success");
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public StandardReponse deletBannedUid(@RequestBody Uid[] uids){
        uidService.deletUid(uids);
        return new StandardReponse("success");
    }

}