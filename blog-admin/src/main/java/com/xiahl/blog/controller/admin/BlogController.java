package com.xiahl.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 夏浩磊
 * @version 1.0
 * @date 2022/3/20 15:06
 * @Desc
 */

@Controller
@RequestMapping("/admin")
public class BlogController {

    @GetMapping("/blogs")
    public String blogs() {
        return "admin/blogs";
    }
}
