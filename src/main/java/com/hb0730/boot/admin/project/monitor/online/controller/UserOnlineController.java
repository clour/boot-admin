package com.hb0730.boot.admin.project.monitor.online.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.hb0730.boot.admin.domain.result.Result;
import com.hb0730.boot.admin.domain.result.Results;
import com.hb0730.boot.admin.project.monitor.online.model.dto.UserOnlineDTO;
import com.hb0730.boot.admin.project.monitor.online.model.query.UserOnlineParams;
import com.hb0730.boot.admin.project.monitor.online.service.IUserOnlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户在线信息
 *
 * @author bing_huang
 * @since 3.0.0
 */
@RestController
@RequestMapping("/api/v3/monitor/online/user")
@RequiredArgsConstructor
public class UserOnlineController {
    private final IUserOnlineService service;


    /**
     * 获取在线用户
     *
     * @param params 过滤条件
     * @return 在线用户
     */
    @PostMapping("/list/page")
    public Result<Page<UserOnlineDTO>> getAllPage(@RequestBody UserOnlineParams params) {
        List<UserOnlineDTO> onlineUser = service.getOnlineUser(params);
        Page<UserOnlineDTO> page = new Page<>();
        page.setRecords(onlineUser);
        page.setTotal(onlineUser.size());
        return Results.resultSuccess(page);
    }

    /**
     * 强退
     *
     * @param token token
     * @return 是否成功
     */
    @GetMapping("/logout/{token}")
    public Result<String> logout(@PathVariable String token) {
        List<String> accessToken = Lists.newArrayList();
        accessToken.add(token);
        service.logout(accessToken);
        return Results.resultSuccess("退出成功");
    }

    /**
     * 强制退出
     *
     * @param tokens token
     * @return 是否成功
     */
    @PostMapping("/logout")
    public Result<String> logout(@RequestBody List<String> tokens) {
        service.logout(tokens);
        return Results.resultSuccess("退出成功");
    }
}
