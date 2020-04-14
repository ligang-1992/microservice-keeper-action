package com.moon.content.center.framework.sentinel;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moon.content.center.common.exception.ErrorMessage;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 定义sentinel报错提示
 * @author: 无忧
 * @date: 2020-04-14 20:42
 */
@Component
public class ContentUrlBlockHandler implements UrlBlockHandler {
    @Override
    public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException e) throws IOException {

        ErrorMessage message = null;
        if (e instanceof FlowException) {
            message = ErrorMessage.builder()
                    .status(100)
                    .message("限流了")
                    .build();

        } else if (e instanceof DegradeException) {
            message = ErrorMessage.builder()
                    .status(101)
                    .message("降级了")
                    .build();

        } else if (e instanceof ParamFlowException) {
            message = ErrorMessage.builder()
                    .status(102)
                    .message("热点参数限流")
                    .build();

        } else if (e instanceof SystemBlockException) {
            message = ErrorMessage.builder()
                    .status(103)
                    .message("系统规则（负载/...不满足要求）")
                    .build();

        } else if (e instanceof AuthorityException) {
            message = ErrorMessage.builder()
                    .status(104)
                    .message("授权规则不通过")
                    .build();
        }

        // http状态码
        response.setStatus(500);
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type", "application/json;charset=utf-8");
        response.setContentType("application/json;charset=utf-8");
        // spring mvc自带的json操作工具，叫jackson
        new ObjectMapper().writeValue(
                response.getWriter(),
                message
        );
    }
}
