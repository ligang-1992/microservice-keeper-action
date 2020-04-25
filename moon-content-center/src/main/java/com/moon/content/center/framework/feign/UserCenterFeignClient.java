package com.moon.content.center.framework.feign;

import com.moon.content.center.framework.sentinel.fallbackfactory.UserCenterFeignClientFallBackFactory;
import com.moon.content.center.module.domain.dto.user.UserAddBonusDTO;
import com.moon.content.center.module.domain.dto.user.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-07 00:31
 */
//@FeignClient(name = "user-center")
@FeignClient(name = "user-center",
//        configuration = UserCenterFeignConfiguration.class
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
    @PutMapping("/bonus/add-bonus")
    UserDTO addBonus(@RequestBody UserAddBonusDTO message);
}
