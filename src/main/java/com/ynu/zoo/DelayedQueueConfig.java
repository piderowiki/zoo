package com.ynu.zoo;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DelayedQueueConfig {
    // 队列
    public static final String DELAYED_QUEUE_NAME  = "delayed.queue";
    // 交换机
    public static final String DELAYED_EXCHANGE_NAME  = "delayed.exchange";
    // routingKey
    public static final String DELAYED_ROUTING_NAME  = "delayed.routingkey";

    @Bean("offlineHealerExchange")
    public DirectExchange offlineHealerExchange(){
        return new DirectExchange("offlineHealerExchange");
    }

    // 交换机声明
    // 因为是插件，所以是自定义交换机
    @Bean
    public CustomExchange delayedExchange(){
        // 自定义交换机需要满足下面的条件
        /*
         1.交换机名称;2.交换机类型;3.是否需要持久化
         4.是否需要自动删除 5.其它参数
         */
        Map<String,Object> arguments = new HashMap<>();
        arguments.put("x-delayed-type","direct"); // 延迟类型,是这个插件的内容
        return new CustomExchange(DELAYED_EXCHANGE_NAME,"x-delayed-message",
                true,false,arguments);
    }
    // 队列
    @Bean
    public Queue delayedQueue(){
        return new Queue(DELAYED_QUEUE_NAME);
    }

    // 绑定
    @Bean
    public Binding delayedQueueBindingDelayedExchange(@Qualifier("delayedQueue")Queue delayedQueue, @Qualifier("delayedExchange")CustomExchange delayedExchange){
        // noargs是一个构建方法
        return BindingBuilder.bind(delayedExchange).to(delayedExchange).with(DELAYED_ROUTING_NAME).noargs();
    }
}
