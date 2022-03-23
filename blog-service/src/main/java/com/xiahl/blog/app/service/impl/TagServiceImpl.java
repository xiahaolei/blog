package com.xiahl.blog.app.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiahl.blog.app.service.TagService;
import com.xiahl.blog.app.service.TypeService;
import com.xiahl.blog.domain.SysUser;
import com.xiahl.blog.entity.Tag;
import com.xiahl.blog.entity.Type;
import com.xiahl.blog.entity.User;
import com.xiahl.blog.repository.login.TagMapper;
import com.xiahl.blog.repository.login.TypeMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * 用户管理
 * @author Louis
 * @date Jun 29, 2019
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}
