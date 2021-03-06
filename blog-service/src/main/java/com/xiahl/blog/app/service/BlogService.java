package com.xiahl.blog.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiahl.blog.entity.Blog;
import com.xiahl.blog.entity.Tag;
import com.xiahl.blog.queryvo.BlogQuery;

import java.util.List;

/**
 * @author 夏浩磊
 * @version 1.0
 * @date 2022/3/21 22:30
 * @Desc
 */
public interface BlogService extends IService<Blog> {

    List<BlogQuery> getAllBlog();

}
