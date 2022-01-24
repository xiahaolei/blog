package com.xiahl.blog.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xiahl.blog.app.service.UserService;
import com.xiahl.blog.domain.SysUser;
import com.xiahl.blog.security.filter.JwtAuthenticatioToken;
import com.xiahl.blog.security.utils.SecurityUtils;
import com.xiahl.blog.security.vo.HttpResult;
import com.xiahl.blog.security.vo.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Wrapper;
import java.util.Objects;

/**
 * 登录控制器
 *
 * @author Louis
 * @date Jun 29, 2019
 */
@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    /**
     * 登录接口
     */
    @PostMapping(value = "/login")
    public HttpResult login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) throws Exception {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        SysUser user = userService.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, username));
        if (Objects.isNull(user)){
            throw new Exception("用户名不存在");
        }
        // 系统登录认证
        JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);

        return HttpResult.ok(token);
    }

}