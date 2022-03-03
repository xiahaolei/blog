package com.xiahl.blog.controller;

import com.xiahl.blog.Exception.MyNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 夏浩磊
 * @version 1.0
 * @date 2022/3/3 0:38
 * @Desc
 */

@Controller
public class IndexController {
    @GetMapping("/{id}/{name}")
    public String index(@PathVariable  Integer id,@PathVariable  String name){
        System.out.println("--------------------index--------------");
        return "index";
    }
}
