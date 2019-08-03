package com.heiyu.bilibiliantiadsplatfrom.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heiyu.bilibiliantiadsplatfrom.Domain.UidLog;
import com.heiyu.bilibiliantiadsplatfrom.Domain.UidLogVO;
import com.heiyu.bilibiliantiadsplatfrom.Domain.UidVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static com.heiyu.bilibiliantiadsplatfrom.Common.Namespace.getUidNamespace;

/**
 * @ClassName: UIdLogService
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 17:10 2019/8/3
 * @Version: 1.0
 **/
@Service
public class UidLogService {

    @Autowired
    private RedisTemplate redisTemplate;

    private ObjectMapper objectMapper;

    public Set<UidLogVO> getLogService(Long id) throws IOException {

        Long start = (id==null)?0:id+1;
        Set<String> strs = redisTemplate.opsForZSet().rangeByScore(getUidNamespace(),start ,Long.MAX_VALUE);
        Set<UidLogVO> set  = new HashSet<>();
        for(String str : strs){
            set.add((UidLogVO)objectMapper.readValue(str,UidLogVO.class));
        }
        return set;
    }
}
