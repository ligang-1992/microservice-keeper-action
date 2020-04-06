package com.moon.content.center.module.service.impl;



import com.moon.content.center.common.constant.BusinessConsts;
import com.moon.content.center.module.domain.dto.ShareAddDTO;
import com.moon.content.center.module.domain.entity.Share;
import com.moon.content.center.module.mapper.ShareMapper;
import com.moon.content.center.module.service.ShareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-06 01:45
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareServiceImpl implements ShareService {

    private final ShareMapper shareMapper;

    /**
     * 通过ID查找分享内容
     *
     * @param id
     * @return
     */
    @Override
    public Share findShareById(String id) {
        return this.shareMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增分享
     *
     * @param dto
     * @return
     */
    @Override
    public Share add(ShareAddDTO dto) {
        Share share = Share.builder()
                .id(UUID.randomUUID().toString().replace("-", ""))
                .userId(dto.getUserId())
                .title(dto.getTitle())
                .createTime(new Date())
                .updateTime(new Date())
                .isOriginal(dto.getIsOriginal())
                .author(dto.getAuthor())
                .cover(dto.getCover())
                .summary(dto.getSummary())
                .price(dto.getPrice())
                .downloadUrl(dto.getDownloadUrl())
                .buyCount(0)
                .showFlag(true)
                .auditStatus(BusinessConsts.AUDIT_STATUS_NOT_YET)
                .build();
        this.shareMapper.insert(share);

        Share result = this.shareMapper.selectByPrimaryKey(share.getId());
        return result;
    }
}
