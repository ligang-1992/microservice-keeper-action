package com.moon.content.center.framework.sentinel.fallbackfactory;

import com.moon.content.center.framework.feign.UserCenterFeignClient;
import com.moon.content.center.module.domain.dto.user.UserAddBonusDTO;
import com.moon.content.center.module.domain.dto.user.UserAddBonusMessageDTO;
import com.moon.content.center.module.domain.dto.user.UserDTO;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-10 23:29
 */
@Slf4j
@Component
public class UserCenterFeignClientFallBackFactory implements FallbackFactory<UserCenterFeignClient> {
    @Override
    public UserCenterFeignClient create(Throwable throwable) {
        return new UserCenterFeignClient() {
            @Override
            public UserDTO findUserById(String id) {
                log.warn("远程调用被限流，或者降级", throwable);
                UserDTO userDTO = new UserDTO();
                userDTO.setWxNickname("一个默认的用户");
                return userDTO;
            }

            @Override
            public UserDTO addBonus(UserAddBonusDTO message) {
                log.warn("远程调用被限流，或者降级", throwable);
                UserDTO userDTO = new UserDTO();
                userDTO.setId(message.getUserId());
                userDTO.setBonus(message.getBonus());
                userDTO.setWxNickname("一个默认的用户");
                return userDTO;
            }
        };
    }
}
