package com.moon.content.center.module.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-06 02:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShareAddDTO implements Serializable {
    /**
     * 发布人id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 是否原创 0:否 1:是
     */
    @Column(name = "is_original")
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
    @Column(name = "download_url")
    private String downloadUrl;

    /**
     * 是否显示 0:否 1:是
     */
    @Column(name = "show_flag")
    private Boolean showFlag;
}
