package com.xiahl.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiahl.blog.app.service.TagService;
import com.xiahl.blog.entity.Tag;
import com.xiahl.blog.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TagsController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags/input")
    public String input(Model model) {
        return "admin/tags-input";
    }

    @GetMapping("/tags")
    public String types(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, Model model) {
        String orderBy = "id desc";
        PageHelper.startPage(pageNum, 3);
        List<Tag> list = tagService.list();
        PageInfo<Tag> pageInfo = new PageInfo<Tag>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/tags";
    }
}
