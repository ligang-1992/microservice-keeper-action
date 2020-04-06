package com.moon.content.center.module.domain.dto.content;

import com.moon.content.center.common.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-06 18:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShareDTO extends BaseEntity {
    /**
     * id
     */
    private String id;

    /**
     * 发布人id
     */
    private String userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否原创 0:否 1:是
     */
    private Boolean isOriginal;

    /**
     * 作者
     */
    private String author;

    /**
     * 封面
     */
    private String cover;

    /**
     * 概要信息
     */
    private String summary;

    /**
     * 价格（需要的积分）
     */
    private Integer price;

    /**
     * 下载地址
     */
    private String downloadUrl;

    /**
     * 下载数
     */
    private Integer buyCount;

    /**
     * 是否显示 0:否 1:是
     */
    private Boolean showFlag;

    /**
     * 审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过
     */
    private String auditStatus;

    /**
     * 审核不通过原因
     */
    private String reason;

    /**
     * 发布人
     */
    private String wxNickname;
}
