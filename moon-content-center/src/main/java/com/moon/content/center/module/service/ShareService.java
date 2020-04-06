package com.moon.content.center.module.service;

import com.moon.content.center.module.domain.dto.content.ShareAddDTO;
import com.moon.content.center.module.domain.dto.content.ShareDTO;
import com.moon.content.center.module.domain.entity.Share;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-06 01:45
 */
public interface ShareService {
    /**
     * 通过ID查找分享内容
     * @param id
     * @return
     */
    ShareDTO findShareById(String id);

    /**
     * 新增分享
     * @param share
     * @return
     */
    Share save(ShareAddDTO share);
}
