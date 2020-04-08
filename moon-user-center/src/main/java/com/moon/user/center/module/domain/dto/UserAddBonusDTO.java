package com.moon.user.center.module.domain.dto;

import com.moon.user.center.common.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-02 02:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAddBonusDTO extends BaseEntity {

    private String userId;
    /**
     * 积分
     */
    private Integer bonus;
}
