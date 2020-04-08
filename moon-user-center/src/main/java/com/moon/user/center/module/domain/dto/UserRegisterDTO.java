package com.moon.user.center.module.domain.dto;

import com.moon.user.center.common.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-04 21:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterDTO extends BaseEntity {

    @Column(name = "wx_id")
    private String wxId;

    /**
     * 微信昵称
     */
    @Column(name = "wx_nickname")
    private String wxNickname;

    /**
     * 头像地址
     */
    @Column(name = "avatar_url")
    private String avatarUrl;
}
