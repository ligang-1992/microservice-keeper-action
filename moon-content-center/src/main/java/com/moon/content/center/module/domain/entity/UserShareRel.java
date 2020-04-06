package com.moon.content.center.module.domain.entity;

import com.moon.content.center.common.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-03 00:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_share_rel")
public class UserShareRel extends BaseEntity {
    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    /**
     * share.id
     */
    @Column(name = "share_id")
    private String shareId;

    /**
     * user.id
     */
    @Column(name = "user_id")
    private String userId;
}