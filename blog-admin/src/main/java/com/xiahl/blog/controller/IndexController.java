package com.xiahl.blog.controller;

import com.xiahl.blog.Exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 夏浩磊
 * @version 1.0
 * @date 2022/3/3 0:38
 * @Desc
 */

@Controller
public class IndexController {
    @GetMapping("/index")
    public String index(){
        String blog = null;
        if (blog==null){
            throw new NotFoundException("博客不存在");
        }
        return "index";
    }
}
