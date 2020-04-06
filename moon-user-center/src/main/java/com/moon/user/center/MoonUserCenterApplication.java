package com.moon.user.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-02 18:26
 */
@MapperScan("com.moon.user.center.module.mapper")
@SpringBootApplication
//@EnableBinding(Sink.class)
public class MoonUserCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoonUserCenterApplication.class, args);
    }

}
