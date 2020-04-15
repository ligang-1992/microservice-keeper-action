package com.moon.content.center.module.controller;

import com.moon.content.center.module.domain.dto.content.ShareAuditDTO;
import com.moon.content.center.module.domain.entity.Share;
import com.moon.content.center.module.service.ShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-14 22:54
 */
@RestController
@RequestMapping("/admin/share")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareAdminController {

    private final ShareService shareService;

    /**
     * 审核分享文章
     *
     * @param id
     * @param auditDTO
     * @return
     */
    @PutMapping("/audit/{id}")
    public Share auditById(@PathVariable String id, @RequestBody ShareAuditDTO auditDTO) {
        return this.shareService.auditById(id, auditDTO);
    }
}
