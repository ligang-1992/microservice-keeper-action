package com.moon.content.center.module.service;

import com.moon.content.center.module.domain.dto.content.ShareAuditDTO;
import com.moon.content.center.module.domain.dto.content.ShareDTO;
import com.moon.content.center.module.domain.dto.content.ShareSaveDTO;
import com.moon.content.center.module.domain.entity.Share;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-06 01:45
 */
public interface ShareService {
    /**
     * 通过ID查找分享内容
     *
     * @param id
     * @return
     */
    ShareDTO findShareById(String id);

    /**
     * 新增分享
     *
     * @param share
     * @return
     */
    Share save(ShareSaveDTO share);

    /**
     * 审核分享文章
     *
     * @param id
     * @param auditDTO
     * @return
     */
    Share auditById(String id, ShareAuditDTO auditDTO);
}
