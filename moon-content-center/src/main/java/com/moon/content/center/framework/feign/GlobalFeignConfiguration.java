package com.moon.content.center.framework.feign;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-07 00:42
 */
public class GlobalFeignConfiguration {

    @Bean
    public Logger.Level level() {
        // 设置Feign打印的日志级别
        return Logger.Level.FULL;
    }
}
