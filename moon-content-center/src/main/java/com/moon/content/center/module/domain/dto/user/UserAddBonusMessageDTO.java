package com.moon.content.center.module.domain.dto.user;

import com.moon.content.center.common.base.BaseEntity;
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
public class UserAddBonusMessageDTO extends BaseEntity {
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