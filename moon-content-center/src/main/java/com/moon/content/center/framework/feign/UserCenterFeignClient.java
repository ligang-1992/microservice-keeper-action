package com.moon.content.center.framework.feign;

import com.moon.content.center.framework.sentinel.fallbackfactory.UserCenterFeignClientFallBackFactory;
import com.moon.content.center.module.domain.dto.user.UserAddBonusMessageDTO;
import com.moon.content.center.module.domain.dto.user.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-07 00:31
 */
//@FeignClient(name = "user-center", configuration = UserCenternFeignConfiguration.class)
@FeignClient(name = "user-center",
        fallbackFactory = UserCenterFeignClientFallBackFactory.class)
public interface UserCenterFeignClient {

    /**
     * 通过ID查询用户信息：http://user-center/users/{id}
     *
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    UserDTO findUserById(@PathVariable String id);

    /**
     * 为用户增加积分
     *
     * @param message
     * @return
     */
    @PostMapping("/bonus/add-bonus")
    @ResponseBody
    UserDTO addBonus(UserAddBonusMessageDTO message);
}
