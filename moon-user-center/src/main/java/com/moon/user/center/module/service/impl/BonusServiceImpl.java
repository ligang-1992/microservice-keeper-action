package com.moon.user.center.module.service.impl;

import com.moon.user.center.module.domain.dto.UserAddBonusMessageDTO;
import com.moon.user.center.module.domain.entity.BonusEventLog;
import com.moon.user.center.module.domain.entity.User;
import com.moon.user.center.module.mapper.BonusEventLogMapper;
import com.moon.user.center.module.mapper.UserMapper;
import com.moon.user.center.module.service.BonusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-02 02:15
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BonusServiceImpl implements BonusService {

    private final UserMapper userMapper;
    private final BonusEventLogMapper bonusEventLogMapper;

    /**
     * 增加积分
     *
     * @param message
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.REPEATABLE_READ, timeout = 30)
    @Override
    public void addBonus(UserAddBonusMessageDTO message) {

        // 1. 为用户加积分
        String userId = message.getUserId();
        Integer bonus = message.getBonus();
        User user = this.userMapper.selectByPrimaryKey(userId);
        user.setBonus(user.getBonus() + bonus);
        this.userMapper.updateByPrimaryKeySelective(user);

        // 2. 记录日志到bonus_event_log表里面
        this.bonusEventLogMapper.insert(
                BonusEventLog.builder()
                        .userId(userId)
                        .value(bonus)
                        .event(message.getEvent())
                        .createTime(new Date())
                        .description(message.getDescription())
                        .build()
        );

        log.info("积分添加完成");
    }
}
