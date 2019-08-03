package com.heiyu.bilibiliantiadsplatfrom.Controller;

import com.heiyu.bilibiliantiadsplatfrom.Domain.StandardReponse;
import com.heiyu.bilibiliantiadsplatfrom.Domain.UidLogVO;
import com.heiyu.bilibiliantiadsplatfrom.Service.UidLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


/**
 * @ClassName: BannedUidLogController
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 15:11 2019/8/3
 * @Version: 1.0
 **/
@RestController
@RequestMapping(path = "/banneduidlog")
public class BannedUidLogController {

    @Autowired
    UidLogService uidLogService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(method = GET)
    public StandardReponse<Set<UidLogVO>> getLog(@RequestBody String id) throws IOException {
        return new StandardReponse<Set<UidLogVO>>(uidLogService.getLogService(Long.valueOf(id)));
    }


}
