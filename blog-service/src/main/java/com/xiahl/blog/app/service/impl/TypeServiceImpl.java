package com.xiahl.blog.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiahl.blog.app.service.TypeService;
import com.xiahl.blog.app.service.UserService;
import com.xiahl.blog.entity.Type;
import com.xiahl.blog.entity.User;
import com.xiahl.blog.repository.login.TypeMapper;
import com.xiahl.blog.repository.login.UserMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 夏浩磊
 * @version 1.0
 * @date 2022/3/21 22:43
 * @Desc
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {
    @Override
    @Transactional
    public Type saveType(Type type) {
        return null;
    }

    @Override
    public Type getType(Long id) {
        return null;
    }

    @Override
    public Page<Type> listType(Pageable pageable) {
        return null;
    }

    @Override
    @Transactional
    public Type updateType(Long id, Type type) {
        return null;
    }

    @Override
    @Transactional
    public void deleteType(Long id) {

    }
}
