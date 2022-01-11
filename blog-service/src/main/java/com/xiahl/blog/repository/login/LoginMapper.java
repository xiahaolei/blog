package com.xiahl.blog.repository.login;

import com.xiahl.blog.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 夏浩磊
 * @version 1.0
 * @date 2022/1/11 16:49
 * @Desc
 */
public interface LoginMapper {

    User login(@Param("userName") String userName,
               @Param("password") String password);
}
