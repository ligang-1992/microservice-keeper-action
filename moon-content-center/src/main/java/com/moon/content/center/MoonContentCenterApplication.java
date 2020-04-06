package com.moon.content.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-02 18:26
 */
@MapperScan("com.moon.content.center.module.mapper")
@SpringBootApplication
public class MoonContentCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoonContentCenterApplication.class, args);
    }

}
