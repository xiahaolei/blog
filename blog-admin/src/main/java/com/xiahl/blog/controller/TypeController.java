package com.xiahl.blog.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiahl.blog.app.service.TypeService;
import com.xiahl.blog.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 夏浩磊
 * @version 1.0
 * @date 2022/3/21 22:52
 * @Desc
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String types(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, Model model) {
        String orderBy = "id desc";
        PageHelper.startPage(pageNum, 3);
        List<Type> list = typeService.list();
        PageInfo<Type> pageInfo = new PageInfo<Type>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input() {
        return "admin/types-input";
    }


    @PostMapping("types")
    public String post(Type type) {
        boolean flag = typeService.save(type);
        if (flag==false){
//            return "保存失败";
        }else {
//            return "保存成功";
        }
        return "redirect:/admin/types";
    }
}
