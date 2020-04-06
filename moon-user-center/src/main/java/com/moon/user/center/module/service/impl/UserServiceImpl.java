package com.moon.user.center.module.service.impl;

import com.moon.user.center.module.domain.dto.UserRegisterDTO;
import com.moon.user.center.module.domain.entity.User;
import com.moon.user.center.module.mapper.UserMapper;
import com.moon.user.center.module.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-02 01:36
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    /**
     * 通过ID查询用户
     *
     * @param id
     * @return
     */
    @Override
    public User findUserById(String id) {

        return this.userMapper.selectByPrimaryKey(id);
    }

    /**
     * 注册
     *
     * @param bean
     * @return
     */
    @Override
    public User register(UserRegisterDTO bean) {
        User user = User.builder()
                .id(UUID.randomUUID().toString().replace("-", ""))
                .wxId(bean.getWxId())
                .wxNickname(bean.getWxNickname())
                .avatarUrl(bean.getAvatarUrl())
                .roles("user")
                .createTime(new Date())
                .updateTime(new Date())
                .bonus(300)
                .build();
        int insert = this.userMapper.insert(user);

        if (insert < 1) {
            throw new IllegalArgumentException("注册失败");
        }

        return this.userMapper.selectByPrimaryKey(user.getId());
    }


}
