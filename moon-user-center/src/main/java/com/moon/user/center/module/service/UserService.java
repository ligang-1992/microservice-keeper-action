package com.moon.user.center.module.service;

import com.moon.user.center.module.domain.dto.UserAddBonusMessageDTO;
import com.moon.user.center.module.domain.dto.UserRegisterDTO;
import com.moon.user.center.module.domain.entity.User;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-02 01:35
 */
public interface UserService {
    /**
     * 通过ID查询用户
     * @param id
     * @return
     */
    User findUserById(String id);


    /**
     * 注册
     * @param
     * @return
     */
    User register(UserRegisterDTO registerDTO);
}
