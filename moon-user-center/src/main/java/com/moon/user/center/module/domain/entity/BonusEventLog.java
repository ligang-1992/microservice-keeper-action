package com.moon.user.center.module.domain.entity;

import com.moon.user.center.common.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-03 00:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "bonus_event_log")
public class BonusEventLog extends BaseEntity {
    /**
     * Id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    /**
     * user.id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 积分操作值
     */
    private Integer value;

    /**
     * 发生的事件
     */
    private String event;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 描述
     */
    private String description;
}