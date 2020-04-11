package com.moon.content.center.framework.sentinel.fallback;

import com.moon.content.center.framework.feign.UserCenterFeignClient;
import com.moon.content.center.module.domain.dto.user.UserDTO;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-10 23:23
 */
@Component
public class UserCenterFeignClientFallback implements UserCenterFeignClient {

    @Override
    public UserDTO findUserById(String id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setWxNickname("一个默认用户");
        return userDTO;
    }
}
