package com.xiahl.blog.controller;

import com.xiahl.blog.app.service.UserService;
import com.xiahl.blog.domain.SysUser;
import com.xiahl.blog.security.vo.HttpResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;

/**
 * 用户控制器
 * @author xiahl
 * @date 1月29, 2022
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;
    
    @PreAuthorize("hasAuthority('sys:user:view')")
    @GetMapping(value="/findAll")
    public HttpResult findAll() {
        SysUser user = userService.findByUsername("夏浩磊");
        Set<String> permissions = userService.findPermissions("夏浩磊");
        System.out.println(user);
        return HttpResult.ok("the findAll service is called success.");
    }
    
    @PreAuthorize("hasAuthority('sys:user:edit')")
    @GetMapping(value="/edit")
    public HttpResult edit() {
        return HttpResult.ok("the edit service is called success.");
    }
    
    @PreAuthorize("hasAuthority('sys:user:delete')")
    @GetMapping(value="/delete")
    public HttpResult delete() {
        return HttpResult.ok("the delete service is called success.");
    }

}