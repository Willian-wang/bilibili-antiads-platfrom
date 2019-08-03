package com.heiyu.bilibiliantiadsplatfrom.Service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heiyu.bilibiliantiadsplatfrom.Domain.Uid;
import com.heiyu.bilibiliantiadsplatfrom.Domain.UidLog;
import com.heiyu.bilibiliantiadsplatfrom.Domain.UidVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static com.heiyu.bilibiliantiadsplatfrom.Common.Namespace.getUidLogNamespace;
import static com.heiyu.bilibiliantiadsplatfrom.Common.Namespace.getUidNamespace;
import static com.heiyu.bilibiliantiadsplatfrom.Domain.UidLog.uid2UidLog;

@Service
public class UidService {

    @Autowired
    StringRedisTemplate redisTemplate ;

    ObjectMapper objectMapper = new ObjectMapper();

    public  void banUid(Uid uid) throws JsonProcessingException {
        redisTemplate.opsForZSet().add(getUidNamespace(uid),objectMapper.writeValueAsString(uid),uid.getId());
        redisTemplate.opsForZSet().add(getUidNamespace(),objectMapper.writeValueAsString(uid),uid.getId());
        UidLog uidLog = uid2UidLog(uid,"insert");
        redisTemplate.opsForZSet().add(getUidLogNamespace(uidLog),objectMapper.writeValueAsString(uidLog),uidLog.getId());
        redisTemplate.opsForZSet().add(getUidLogNamespace(),objectMapper.writeValueAsString(uidLog),uidLog.getId());

    }

    public Set<UidVO> getUidList(Uid uid) throws IOException {
        Long start = (uid.getId() == null)?0:uid.getId()+1;
        Set<String> strs = redisTemplate.opsForZSet().rangeByScore(getUidNamespace(),start ,Long.MAX_VALUE);
        Set<UidVO> set  = new HashSet<>();
        for(String str : strs){
            set.add((UidVO)objectMapper.readValue(str,UidVO.class));
        }
        return  set;
    }

    public void deletUid(Uid[] uids) throws JsonProcessingException {
        for(Uid uid :uids) {
            redisTemplate.opsForZSet().remove(getUidNamespace(), uid.getUid().toString());
            UidLog uidLog = uid2UidLog(uid,"delete");
            redisTemplate.opsForZSet().add(getUidLogNamespace(),objectMapper.writeValueAsString(uidLog),uidLog.getId());
        }
    }
}
