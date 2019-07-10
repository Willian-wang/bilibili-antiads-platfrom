package com.heiyu.bilibiliantiadsplatfrom.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

@RestController
@RequestMapping(path = "/banneduid")
public class BannedUidController {

    @RequestMapping(method = RequestMethod.GET)
    public String getBannedUid(){
        return "walala";
    }
}
