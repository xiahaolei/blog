package com.xiahl.blog.controller.admin;

import com.xiahl.blog.app.service.UserService;
import com.xiahl.blog.entity.User;
import com.xiahl.blog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author 夏浩磊
 * @version 1.0
 * @date 2022/3/19 19:25
 * @Desc
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String loginPage(){
        return "/admin/login";
    }

    @PostMapping("/login")
    public String  login(@RequestParam String username , @RequestParam String password, HttpSession session, RedirectAttributes attributes){
        User user = userService.checkUser(username, MD5Utils.code(password));
        if (user!=null){
            user.setPassword(null);
            session.setAttribute("user",user);
            return "/admin/index";
        }else {
            attributes.addFlashAttribute("message","用户名密码错误");
            return "redirect:/admin";
        }

    }


    @GetMapping("/logout")
    public String loginOut(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
