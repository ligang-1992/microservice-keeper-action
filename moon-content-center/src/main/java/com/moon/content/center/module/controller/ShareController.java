package com.moon.content.center.module.controller;

import com.moon.content.center.module.domain.dto.ShareAddDTO;
import com.moon.content.center.module.domain.entity.Share;
import com.moon.content.center.module.service.ShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-03 00:56
 */
@RestController
@RequestMapping("/share")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareController {

    private final ShareService shareService;

    /**
     * 通过ID查找分享内容
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Share findShareById(@PathVariable String id) {
        return this.shareService.findShareById(id);
    }

    /**
     * 新增分享
     * @param share
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Share add(ShareAddDTO share){
        return this.shareService.add(share);
    }
}
