package com.moon.content.center.module.service.impl;


import com.moon.content.center.common.constant.BusinessConstants;
import com.moon.content.center.framework.feign.UserCenterFeignClient;
import com.moon.content.center.module.domain.dto.content.ShareAuditDTO;
import com.moon.content.center.module.domain.dto.content.ShareDTO;
import com.moon.content.center.module.domain.dto.content.ShareSaveDTO;
import com.moon.content.center.module.domain.dto.user.UserAddBonusMessageDTO;
import com.moon.content.center.module.domain.dto.user.UserDTO;
import com.moon.content.center.module.domain.entity.Share;
import com.moon.content.center.module.mapper.ShareMapper;
import com.moon.content.center.module.service.ShareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;
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
    private final UserCenterFeignClient userCenterFeignClient;

    /**
     * 通过ID查找分享内容
     *
     * @param id
     * @return
     */
    @Override
    public ShareDTO findShareById(String id) {

        Share share = this.shareMapper.selectByPrimaryKey(id);
        // 发布人的ID
        String userId = share.getUserId();
        UserDTO userDTO = this.userCenterFeignClient.findUserById(userId);

        ShareDTO shareDTO = new ShareDTO();
        BeanUtils.copyProperties(share, shareDTO);
        shareDTO.setWxNickname(userDTO.getWxNickname());

        return shareDTO;
    }

    /**
     * 新增分享
     *
     * @param dto
     * @return
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.REPEATABLE_READ, timeout = 30)
    @Override
    public Share save(ShareSaveDTO dto) {
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
                .auditStatus(BusinessConstants.AUDIT_STATUS_NOT_YET)
                .build();
        this.shareMapper.insert(share);

        Share result = this.shareMapper.selectByPrimaryKey(share.getId());
        return result;
    }

    /**
     * 审核分享文章
     *
     * @param id
     * @param auditDTO
     * @return
     */

    @Async
//    @Transactional(rollbackFor = Exception.class, isolation = Isolation.REPEATABLE_READ, timeout = 30)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Share auditById(String id, ShareAuditDTO auditDTO) {
        // 1. 查询share是否存在，不存在或者当前的audit_status != NOT_YET，那么抛异常
        Share share = this.shareMapper.selectByPrimaryKey(id);
        if (share == null) {
            throw new IllegalArgumentException("参数非法！该分享不存在！");
        }
        if (!Objects.equals(BusinessConstants.AUDIT_STATUS_NOT_YET, share.getAuditStatus())) {
            throw new IllegalArgumentException("参数非法！该分享已审核通过或审核不通过！");
        }

        // 修改分享文章审核状态
        share.setAuditStatus(auditDTO.getAuditStatusEnum().toString());
        share.setReason(auditDTO.getReason());
        this.shareMapper.updateByPrimaryKeySelective(share);

        // 异步增加用户积分
        userCenterFeignClient.addBonus(
                UserAddBonusMessageDTO.builder()
                        .userId(share.getUserId())
                        .bonus(100)
                        .description("兑换分享")
                        .event("")
                        .build()
        );
        return share;
    }
}
