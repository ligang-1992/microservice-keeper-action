package com.moon.content.center;

import com.moon.content.center.common.configuration.GlobalFeignConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-02 18:26
 */
@Slf4j
@MapperScan("com.moon.content.center.module.mapper")
@SpringBootApplication
@EnableFeignClients //(defaultConfiguration = GlobalFeignConfiguration.class)
public class MoonContentCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoonContentCenterApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        log.info("服务请求...");
        return new RestTemplate();
    }

}
