package com.moon.content.center.framework.sentinel;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlCleaner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-14 21:54
 */
@Slf4j
@Component
public class ContentUrlCleaner implements UrlCleaner {
    @Override
    public String clean(String url) {
        log.info("origin url: {}", url);

        // 让/share/1 与 /share/2 的返回值相同
        // 返回/shares/{number}
        String[] split = url.split("/");
        return Arrays.stream(split).map(string -> {
            if (string.equals(split[split.length - 1])) {
                return "{string}";
            }

//            // TODO 判断是不是ID的长度
//            if (string.length() >= BusinessConsts.ID_LENGTH) {
//                return "{string}";
//            }

            return string;
        }).reduce((a, b) -> a + "/" + b).orElse("");
    }
}
