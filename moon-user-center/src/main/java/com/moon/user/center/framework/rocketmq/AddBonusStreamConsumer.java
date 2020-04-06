package com.moon.user.center.framework.rocketmq;

import com.moon.user.center.common.constant.BonusConsts;
import com.moon.user.center.module.domain.dto.UserAddBonusMessageDTO;
import com.moon.user.center.module.service.BonusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 整合RocketMQ
 * @author: 无忧
 * @date: 2020-04-02 01:44
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AddBonusStreamConsumer {

    private final BonusService bonusService;

    //    @StreamListener(Sink.INPUT)
    private void receive(UserAddBonusMessageDTO message) {
        message.setEvent(BonusConsts.EVENT_CONTRIBUTE);
        message.setDescription("投稿加积分");
        this.bonusService.addBonus(message);
    }
}
