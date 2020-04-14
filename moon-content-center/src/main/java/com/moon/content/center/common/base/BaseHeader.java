package com.moon.content.center.common.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-14 21:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseHeader implements Serializable {

    /**
     * 操作人员
     */
    private String userId;

    /**
     * 认证的token
     */
    private String accessToken;

    /**
     * sentinel origin
     */
    private String origin;
}
