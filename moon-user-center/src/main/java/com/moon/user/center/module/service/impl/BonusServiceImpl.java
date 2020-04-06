package com.moon.user.center.module.service.impl;

import com.moon.user.center.module.domain.dto.UserAddBonusMessageDTO;
import com.moon.user.center.module.service.BonusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-02 02:15
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BonusServiceImpl implements BonusService {

    /**
     * 增加积分
     * @param message
     */
    @Override
    public void addBonus(UserAddBonusMessageDTO message) {

    }
}
