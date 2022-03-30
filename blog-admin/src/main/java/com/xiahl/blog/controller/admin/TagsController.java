package com.xiahl.blog.controller.admin;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiahl.blog.app.service.TagService;
import com.xiahl.blog.entity.Tag;
import com.xiahl.blog.entity.Type;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
@Api(value = "标签接口",tags = "标签接口")
public class TagsController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    @ApiOperation(value = "分页请求页面")
    public String types(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, Model model) {
        String orderBy = "id desc";
        PageHelper.startPage(pageNum, 3);
        List<Tag> list = tagService.list();
        PageInfo<Tag> pageInfo = new PageInfo<Tag>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/tags";
    }

    @GetMapping("/tags/input")
    @ApiOperation(value = "点击新增跳转页面")
    public String input(Model model) {
        model.addAttribute("tag", new Tag());
        return "admin/tags-input";
    }


    @GetMapping("tags/{id}/input")
    @ApiOperation(value = "编辑页面回显")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("tag", tagService.getById(id));
        return "admin/tags-input";
    }


    @PostMapping("/tags")
    @ApiOperation(value = "新增")
    public String post(@Validated Tag tag, BindingResult result, RedirectAttributes attributes) {
        if (tag.getName() != null) {
            Tag tagOne = tagService.getOne(Wrappers.<Tag>lambdaQuery().eq(Tag::getName, tag.getName()));
            if (tagOne != null) {
                result.rejectValue("name", "name:Error", "标签名称不能重复添加");
            }
        }
        if (result.hasErrors()) {
            return "admin/tags-input";
        }
        boolean flag = tagService.save(tag);
        if (flag == false) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/tags";
    }

    @PostMapping("/tags/{id}")
    @ApiOperation(value = "编辑")
    public String editPost(@Validated Tag tag, BindingResult result, @PathVariable Long id, RedirectAttributes attributes) {
        if (tag.getName() != null) {
            Tag tagOne = tagService.getOne(Wrappers.<Tag>lambdaQuery().eq(Tag::getName, tag.getName()));
            if (tagOne != null) {
                result.rejectValue("name", "name:Error", "分类名称不能重复修改");
            }
        }
        if (result.hasErrors()) {
            return "admin/tags-input";
        }
        Boolean flag =  tagService.update(tag,Wrappers.<Tag>lambdaQuery().eq(Tag::getId,id));
        if (flag == false) {
            attributes.addFlashAttribute("message", "编辑失败");
        } else {
            attributes.addFlashAttribute("message", "编辑成功");
        }
        return "redirect:/admin/tags";
    }


    @GetMapping("/tags/{id}/delete")
    @ApiOperation("删除页面")
    public String delete(@PathVariable  Long id ,RedirectAttributes attributes){
        tagService.removeById(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/tags";
    }

}
