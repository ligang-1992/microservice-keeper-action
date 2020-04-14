package com.moon.content.center.framework.sentinel;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-14 21:00
 */
//@Component
public class ContentRequestOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest request) {
        // 从请求参数中获取名为 origin 的参数并返回
        // 如果获取不到origin参数，那么就抛异常
        String origin = request.getParameter("origin");
        if (StringUtils.isBlank(origin)) {
            throw new IllegalArgumentException("origin must be specified");
        }
        return origin;
    }
}
