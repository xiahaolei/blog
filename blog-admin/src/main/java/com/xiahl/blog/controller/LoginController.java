package com.xiahl.blog.controller;

import com.xiahl.blog.app.service.LoginService;
import com.xiahl.blog.domain.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 夏浩磊
 * @version 1.0
 * @date 2022/1/11 16:33
 * @Desc
 */

@RestController
@RequestMapping("/login")
@ComponentScan(basePackages = "com.xiahl.blog")
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    public String test() {
        boolean flag = loginService.login("夏浩磊", "123456");
        List<User> list = loginService.list();
        System.out.println(list);
        if (flag == true) {
            return "登录成功";
        } else {
            return "登录失败";
        }
    }

}
