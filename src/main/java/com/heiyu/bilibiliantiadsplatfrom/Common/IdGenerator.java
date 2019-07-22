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

import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;


    /**
     * @ClassName: IdGenerator
     * @Description: This is a IdGenerator using SnowFlack.
     * @Author: WangYi
     * @Date: 14:24 2019/7/17
     * @Version: 1.0
     **/

    @Component
    public class IdGenerator {

        static private final long initTimestamp = 1563292800000L;
        // 2019年7月17日 0点0分0秒时间戳

        static private long mask =9007199254740991L;
        //2^52+1 用于限制ID生成算法的最大值。 Redis 有序列表Score 大于10^16就会变成科学计数法

        static private long lastTimestamp;

        static private long serialNum = 0;

        static final private int timeLength = 41;

        static final private int serialNumLength = 12;

        static final private int timeLeft = serialNumLength  ;




        synchronized static public Long getId() {

            if (serialNum > Math.pow(2, serialNumLength) - 1) {
                try {
                    sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            long nowTimestamp = System.currentTimeMillis();
            if (lastTimestamp == nowTimestamp) {
                serialNum++;
            } else {
                lastTimestamp = nowTimestamp;
                serialNum = 0;
            }
            long Id = nowTimestamp - initTimestamp;
            Id = Id << timeLeft | serialNum & mask;
            return Id;
        }
    }




