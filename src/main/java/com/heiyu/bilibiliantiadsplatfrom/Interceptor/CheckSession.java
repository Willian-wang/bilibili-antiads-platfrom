package com.heiyu.bilibiliantiadsplatfrom.Interceptor;

import org.apache.ibatis.plugin.Intercepts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: Login
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 19:43 2019/7/21
 * @Version: 1.0
 **/


public class CheckSession implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies() ;
        String sessionId = "";
        for(Cookie cookie :cookies){
            if(cookie.getName().equals("sessionid")){
               sessionId = cookie.getValue();
            }
        }
        return redisTemplate.opsForSet().isMember("user::auth",sessionId);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
