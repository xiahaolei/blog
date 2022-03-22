package com.xiahl.blog.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiahl.blog.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author 夏浩磊
 * @version 1.0
 * @date 2022/3/21 22:30
 * @Desc
 */

public interface TypeService  extends IService<Type> {

    Type saveType(Type type);


    Type getType(Long id);

    Page<Type> listType(Pageable pageable0);

    Type updateType(Long id, Type type);

    void deleteType(Long id);
}
