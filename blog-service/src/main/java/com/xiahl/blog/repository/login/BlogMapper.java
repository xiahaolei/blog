package com.xiahl.blog.repository.login;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiahl.blog.entity.Blog;
import com.xiahl.blog.entity.Tag;
import com.xiahl.blog.queryvo.BlogQuery;

import java.util.List;

public interface BlogMapper extends BaseMapper<Blog> {
    List<BlogQuery> getAllBlog();

}
