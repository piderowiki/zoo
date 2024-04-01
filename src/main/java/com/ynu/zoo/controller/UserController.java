package com.ynu.zoo.controller;

import com.ynu.zoo.utils.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class UserController {
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/zoo/vistor/logIn/{username}")
    public String visitorLogIn(@PathVariable("username") String userName){
        try {
            // 确保有以下功能:
            // 1.首先是能判重，不能让两个一样的用户进来。
            // 2.那么我们需要确保，连接断开后，就要从redis中删除这个游客
            // 3.但是我们需要保证一定的断线重连能力(那就从MQ中处理)
            if(redisTemplate.opsForValue().get(userName)!= null){
                return "false";
            }
            redisTemplate.opsForValue().set(userName, ConstUtil.USER_IN_HALL);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "false";
    }
}
