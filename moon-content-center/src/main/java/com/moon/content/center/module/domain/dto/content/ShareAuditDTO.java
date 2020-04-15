package com.moon.content.center.module.domain.dto.content;

import com.moon.content.center.common.enums.AuditStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-14 22:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShareAuditDTO {
    /**
     * 审核状态
     */
    private AuditStatusEnum auditStatusEnum;
    /**
     * 原因
     */
    private String reason;
}
