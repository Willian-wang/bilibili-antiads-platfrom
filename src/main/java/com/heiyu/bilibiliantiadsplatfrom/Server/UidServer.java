package com.heiyu.bilibiliantiadsplatfrom.Server;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heiyu.bilibiliantiadsplatfrom.Domain.Uid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.heiyu.bilibiliantiadsplatfrom.Common.Namespace.getUidNamespace;

@Service
public class UidServer {

    @Autowired
    StringRedisTemplate redisTemplate ;

    ObjectMapper objectMapper = new ObjectMapper();

    public  void banUid(Uid uid) throws JsonProcessingException {
        redisTemplate.opsForZSet().add(getUidNamespace(uid),objectMapper.writeValueAsString(uid),uid.getId());
        redisTemplate.opsForZSet().add(getUidNamespace(),objectMapper.writeValueAsString(uid),uid.getId());
    }

    public Set<Uid> getUidList(Uid uid) throws IOException {
        Long start = (uid.getId() == null)?0:uid.getId()+1;
        Set<String> strs = redisTemplate.opsForZSet().rangeByScore(getUidNamespace(),start ,Long.MAX_VALUE);
        Set<Uid> set  = new HashSet<>();
        for(String str : strs){
            set.add((Uid)objectMapper.readValue(str,Uid.class));
        }
        return   set;
    }

    public void deletUid(Uid[] uids) {
        for(Uid uid :uids) {
            redisTemplate.opsForZSet().remove(getUidNamespace(), uid.getUid().toString());
        }
    }
}
