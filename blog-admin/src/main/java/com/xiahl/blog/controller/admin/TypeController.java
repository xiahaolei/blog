package com.xiahl.blog.controller.admin;

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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.Wrapper;
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
    public String types(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, Model model) {
        String orderBy = "id desc";
        PageHelper.startPage(pageNum, 3);
        List<Type> list = typeService.list();
        PageInfo<Type> pageInfo = new PageInfo<Type>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input(Model model) {
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }

    @GetMapping("types/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("type", typeService.getById(id));
        return "admin/types-input";
    }

    @PostMapping("types")
    public String post(@Validated Type type, BindingResult result, RedirectAttributes attributes) {
        if (type.getName() != null) {
            Type typeOne = typeService.getOne(Wrappers.<Type>lambdaQuery().eq(Type::getName, type.getName()));
            if (typeOne != null) {
                result.rejectValue("name", "name:Error", "分类名称不能重复添加");
            }
        }
        if (result.hasErrors()) {
            return "admin/types-input";
        }
        boolean flag = typeService.save(type);
        if (flag == false) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/types";
    }

    @PostMapping("types/{id}")
    public String editPost(@Validated Type type, BindingResult result, @PathVariable Long id, RedirectAttributes attributes) {
        if (type.getName() != null) {
            Type typeOne = typeService.getOne(Wrappers.<Type>lambdaQuery().eq(Type::getName, type.getName()));
            if (typeOne != null) {
                result.rejectValue("name", "name:Error", "分类名称不能重复修改");
            }
        }
        if (result.hasErrors()) {
            return "admin/types-input";
        }
       Boolean flag =  typeService.update(type,Wrappers.<Type>lambdaQuery().eq(Type::getId,id));
        if (flag == false) {
            attributes.addFlashAttribute("message", "编辑失败");
        } else {
            attributes.addFlashAttribute("message", "编辑成功");
        }
        return "redirect:/admin/types";
    }


    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable  Long id ,RedirectAttributes attributes){
        typeService.removeById(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/types";
    }

}
