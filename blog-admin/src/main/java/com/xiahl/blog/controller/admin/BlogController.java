package com.xiahl.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiahl.blog.app.service.BlogService;
import com.xiahl.blog.app.service.TypeService;
import com.xiahl.blog.entity.Blog;
import com.xiahl.blog.entity.User;
import com.xiahl.blog.queryvo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 夏浩磊
 * @version 1.0
 * @date 2022/3/20 15:06
 * @Desc
 */

@Controller
@RequestMapping("/admin")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;

    @GetMapping("/blogs")
    public String blogs(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        //按照排序字段 倒序 排序
        String orderBy = "update_time desc";
        PageHelper.startPage(pageNum,3,orderBy);
        List<BlogQuery> list = blogService.getAllBlog();
        PageInfo<BlogQuery> pageInfo = new PageInfo<BlogQuery>(list);
        model.addAttribute("types",typeService.list());
        model.addAttribute("pageInfo",pageInfo);
            return "admin/blogs";
    }

    //跳转博客新增页面
    @GetMapping("/blogs/input")
    public String input(Model model) {
        model.addAttribute("types",typeService.list());
        model.addAttribute("blog", new Blog());
        return "admin/blogs-input";
    }

    //    博客新增
    @PostMapping("/blogs")
    public String post(Blog blog, RedirectAttributes attributes, HttpSession session){
        blog.setUser((User) session.getAttribute("user"));
        //设置blog的type
        blog.setType(typeService.getType(blog.getType().getId()));
        //设置blog中typeId属性
        blog.setTypeId(blog.getType().getId());
        //设置用户id
        blog.setUserId(blog.getUser().getId());
        boolean b = blogService.save(blog);

        if(b == false){
            attributes.addFlashAttribute("message", "新增失败");
        }else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/blogs";
    }
}
