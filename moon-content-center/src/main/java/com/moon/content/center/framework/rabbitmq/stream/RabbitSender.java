package com.moon.content.center.framework.rabbitmq.stream;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-22 23:43
 */
@Slf4j
@EnableBinding(Barista.class)
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RabbitSender {

    private final Barista barista;

    public String sendMessage(Object message, Map<String, Object> properties) throws Exception {

        try {
            MessageHeaders messageHeaders = new MessageHeaders(properties);
            Message msg = MessageBuilder.createMessage(message, messageHeaders);
            boolean status = barista.logOutput().send(msg);
            log.info("send: " + message + ", status: " + status);
        } catch (Exception e) {
            log.error("--------------");
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

        return null;
    }
}
