package com.moon.user.center.framework.rabbitmq.stream;

import com.rabbitmq.client.Channel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * @description: RabbitMQ 消息接收类
 * @author: 无忧
 * @date: 2020-04-23 00:04
 */
@Slf4j
@EnableBinding(Barista.class)
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RabbitReceiver {

    @StreamListener(Barista.INPUT_CHANNEL)
    public void receiver(Message message) throws Exception {
        Channel channel = (Channel) message.getHeaders().get(AmqpHeaders.CHANNEL);
        Long deliverTag = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        log.info("Input stream message: " + message);
        channel.basicAck(deliverTag, false);
    }
}
