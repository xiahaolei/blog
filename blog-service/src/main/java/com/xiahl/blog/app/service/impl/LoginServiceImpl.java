package com.xiahl.blog.app.service.impl;

import com.xiahl.blog.app.service.LoginService;
import com.xiahl.blog.domain.User;
import com.xiahl.blog.repository.login.LoginMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 夏浩磊
 * @version 1.0
 * @date 2022/1/11 16:39
 * @Desc
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginMapper mapper;

    @Override
    public boolean login(String userName, String password) {
        User login = mapper.login(userName,password);
        if (null != login) {
            return true;
        } else {
            return false;
        }
    }
}
