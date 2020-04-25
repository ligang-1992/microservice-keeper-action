package com.moon.user.center.module.controller;

import com.moon.user.center.common.constant.BonusConsts;
import com.moon.user.center.module.domain.dto.UserAddBonusDTO;
import com.moon.user.center.module.domain.dto.UserAddBonusMessageDTO;
import com.moon.user.center.module.domain.entity.User;
import com.moon.user.center.module.service.BonusService;
import com.moon.user.center.module.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-02 02:13
 */
@RestController
@RequestMapping("/bonus")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BonusController {

    private final BonusService bonusService;
    private final UserService userService;

    @PutMapping("/add-bonus")
    public User addBonus(@RequestBody UserAddBonusDTO bonusDTO) {
        String userId = bonusDTO.getUserId();

        // 新增积分
        this.bonusService.addBonus(
                UserAddBonusMessageDTO.builder()
                        .userId(userId)
                        .bonus(bonusDTO.getBonus())
                        .description("兑换分享")
                        .event(BonusConsts.EVENT_BUY)
                        .build()
        );

        return this.userService.findUserById(userId);
    }


}