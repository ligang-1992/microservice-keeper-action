package com.moon.user.center.module.service;

import com.moon.user.center.module.domain.dto.UserAddBonusMessageDTO;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-02 02:15
 */
public interface BonusService {

    /**
     * 增加积分
     * @param message
     */
    void addBonus(UserAddBonusMessageDTO message);
}
