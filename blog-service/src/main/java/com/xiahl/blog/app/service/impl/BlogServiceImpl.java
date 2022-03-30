package com.xiahl.blog.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiahl.blog.app.service.BlogService;
import com.xiahl.blog.app.service.UserService;
import com.xiahl.blog.entity.Blog;
import com.xiahl.blog.entity.User;
import com.xiahl.blog.repository.login.BlogMapper;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
}
