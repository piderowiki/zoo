package com.ynu.zoo.controller;

import com.ynu.zoo.utils.ConstUtil;
import com.ynu.zoo.utils.ZooMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Slf4j
public class UserController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private AmqpAdmin amqpAdmin;
    @Autowired
    private DirectExchange offlineHealerExchange;

    // 突然想到一个问题,单User没password好像确实
    // 那么,下线状态就把大厅处于 -1 态.
    // 改成检测有没有在线
    @RequestMapping("/zoo/vistor/logIn/{username}")
    public ZooMessage visitorLogIn(@PathVariable("username") String userName){
        log.info("接收到"+userName+"的登录请求");
        // 业务逻辑简单,临时性强,直接集成在controller里面了,不要学,不是好习惯.
        try {
            // 确保有以下功能:
            // 1.首先是能判重，不能让两个一样的用户进来。
            // 2.那么我们需要确保，连接断开后，就要从redis中删除这个游客
            // 3.但是我们需要保证一定的断线重连能力(那就从MQ中处理)
            Integer whereIsUser = (Integer)redisTemplate.opsForValue().get(userName);
            if(whereIsUser != null){
                // 如果用户处于在线状态
                if(whereIsUser != ConstUtil.USER_IN_HALL){
                    return new ZooMessage(ConstUtil.MESSAGE_FAILED,"repeat");
                }
                // 否则设置为在线状态
                redisTemplate.opsForValue().set(userName, ConstUtil.USER_IN_HALL);
                return new ZooMessage(ConstUtil.MESSAGE_SUCCESS,"true");
            }
            // 为这个用户注册唯一的MQ队列
            Queue queue = new Queue(userName + "_queue",true,false,false);
            amqpAdmin.declareQueue(queue);
            amqpAdmin.declareBinding(BindingBuilder.bind(queue).to(offlineHealerExchange).with("normalKey"));
            // 在Redis注册
            redisTemplate.opsForValue().set(userName, ConstUtil.USER_IN_HALL);

            return new ZooMessage(ConstUtil.MESSAGE_SUCCESS,"true");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ZooMessage(ConstUtil.MESSAGE_FAILED,"false");
    }
}
