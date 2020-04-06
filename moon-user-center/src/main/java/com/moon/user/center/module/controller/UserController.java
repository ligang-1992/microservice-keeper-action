package com.moon.user.center.module.controller;

import com.moon.user.center.module.domain.dto.UserRegisterDTO;
import com.moon.user.center.module.domain.entity.User;
import com.moon.user.center.module.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-02 01:32
 */

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class UserController {

    private final UserService userService;

    /**
     * 通过ID查询用户
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User findUserById(@PathVariable String id) {
        log.info("通过ID查询");
        return this.userService.findUserById(id);
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public User register(UserRegisterDTO register) {
        log.info("注册");
        return this.userService.register(register);
    }
}
