package com.moon.content.center.module.domain.dto.user;

import com.moon.content.center.common.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-06 18:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO extends BaseEntity {
    /**
     * Id
     */
    private String id;

    /**
     * 微信id
     */
    private String wxId;

    /**
     * 微信昵称
     */
    private String wxNickname;

    /**
     * 角色
     */
    private String roles;

    /**
     * 头像地址
     */
    private String avatarUrl;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 积分
     */
    private Integer bonus;
}
