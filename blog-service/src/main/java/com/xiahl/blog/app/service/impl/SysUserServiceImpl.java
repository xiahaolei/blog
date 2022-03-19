package com.xiahl.blog.app.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiahl.blog.app.service.UserService;
import com.xiahl.blog.domain.SysUser;
import com.xiahl.blog.entity.User;
import com.xiahl.blog.repository.login.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.HashSet;
import java.util.Set;

@Service
public class SysUserServiceImpl  extends ServiceImpl<UserMapper, User> implements UserService {
	@Autowired
	private UserService userService;
	@Override
	public SysUser findByUsername(String username) {
		SysUser user = new SysUser();
		user.setId(1L);
		user.setUsername(username);
		String password = new BCryptPasswordEncoder().encode("123");
		user.setPassword(password);
		return user;
	}

	@Override
	public Set<String> findPermissions(String username) {
		Set<String> permissions = new HashSet<>();
		permissions.add("sys:user:view");
		permissions.add("sys:user:add");
		permissions.add("sys:user:edit");
		permissions.add("sys:user:delete");
		return permissions;
	}

	@Override
	public User checkUser(String username, String password) {
		User user = userService.getOne(Wrappers.<User>lambdaQuery()
				.eq(User::getUsername, username).eq(User::getPassword,password));
		return user;
	}
}
