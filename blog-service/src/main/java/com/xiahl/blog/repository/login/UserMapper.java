package com.xiahl.blog.repository.login;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiahl.blog.domain.SysUser;
import com.xiahl.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 夏浩磊
 * @version 1.0
 * @date 2022/1/11 16:49
 * @Desc
 */
public interface UserMapper extends BaseMapper<User> {

    SysUser login(@Param("userName") String userName,
               @Param("password") String password);
}
