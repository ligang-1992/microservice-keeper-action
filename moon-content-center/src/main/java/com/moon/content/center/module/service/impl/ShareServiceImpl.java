package com.moon.content.center.module.service.impl;


import com.moon.content.center.common.constant.BusinessConsts;
import com.moon.content.center.module.domain.dto.content.ShareAddDTO;
import com.moon.content.center.module.domain.dto.content.ShareDTO;
import com.moon.content.center.module.domain.dto.user.UserDTO;
import com.moon.content.center.module.domain.entity.Share;
import com.moon.content.center.module.mapper.ShareMapper;
import com.moon.content.center.module.service.ShareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.stream.Collectors.toList;

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
    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

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

        UserDTO user = restTemplate.getForObject(
                "http://user-center/users/{id}",
                UserDTO.class,
                userId
        );
        ShareDTO shareDTO = new ShareDTO();
        BeanUtils.copyProperties(share, shareDTO);
        shareDTO.setWxNickname(user.getWxNickname());

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
    public Share save(ShareAddDTO dto) {
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
