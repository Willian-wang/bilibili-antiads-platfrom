package com.heiyu.bilibiliantiadsplatfrom.Common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
/**
 * @ClassName SnowFlakeId
 * @Description Finish
 * @Author Jayfeather
 * @Date 2019/5/3 16:28
 * @Version 1.0
 **/

@Component
//雪花ID生成器
public class IdGenerator {
    synchronized static public Long getId() {
        return System.currentTimeMillis();
    }
}

