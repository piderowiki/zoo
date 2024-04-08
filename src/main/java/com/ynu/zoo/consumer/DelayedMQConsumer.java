package com.ynu.zoo.consumer;

import com.ynu.zoo.DelayedQueueConfig;
import com.ynu.zoo.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class DelayedMQConsumer {
    @Autowired
    RoomService roomService;
    // 你的任务只有一个,看时间到了就准备删除房间
    @RabbitListener(queues = DelayedQueueConfig.DELAYED_QUEUE_NAME)
    public void roomTimeIsOver(Message message){
        String msg = new String(message.getBody());
    }
}
