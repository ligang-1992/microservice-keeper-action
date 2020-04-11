package com.moon.content.center.framework.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: sentinel 降级或者限流配置类
 * @author: 无忧
 * @date: 2020-04-10 23:10
 */
@Slf4j
public class BlockHandleClass {

    public static String block(String method, BlockException exception) {
        log.warn("限流，或者降级 block", exception);
        return "限流，或者降级 block";
    }
}
