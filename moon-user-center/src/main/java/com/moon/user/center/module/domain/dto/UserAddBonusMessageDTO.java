package com.moon.user.center.module.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-02 01:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAddBonusMessageDTO {
    /**
     * 为谁加积分
     */
    private String userId;
    /**
     * 加多少积分
     */
    private Integer bonus;

    private String description;

    private String event;
}
