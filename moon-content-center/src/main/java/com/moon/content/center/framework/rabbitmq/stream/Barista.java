package com.moon.content.center.framework.rabbitmq.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-22 23:28
 */
public interface Barista {
    String OUTPUT_CHANNEL = "output_channel";

    /**
     * 声明了它是一个输出类型的通道
     * @return
     */
    @Output(Barista.OUTPUT_CHANNEL)
    MessageChannel logOutput();
}
