package com.moon.user.center.framework.rabbitmq.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-22 23:56
 */
public interface Barista {

    String INPUT_CHANNEL = "input_channel";

    /**
     * 注解@Input声明了它是一个输入类型的通道
     * @return
     */
    @Input(Barista.INPUT_CHANNEL)
    SubscribableChannel logInput();
}
