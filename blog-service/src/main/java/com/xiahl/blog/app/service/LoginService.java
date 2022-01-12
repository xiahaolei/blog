package com.xiahl.blog.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiahl.blog.domain.User;

/**
 * @author 夏浩磊
 * @version 1.0
 * @date 2022/1/11 16:37
 * @Desc
 */

public interface LoginService extends IService<User> {
   boolean login(String userName, String password);
}
