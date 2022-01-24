package com.xiahl.blog.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiahl.blog.domain.SysUser;

import java.util.Set;

/**
 * 用户管理
 * @author Louis
 * @date Jun 29, 2019
 */
public interface UserService extends IService<SysUser> {

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	SysUser findByUsername(String username);

	/**
	 * 查找用户的菜单权限标识集合
	 * @param userName
	 * @return
	 */
	Set<String> findPermissions(String username);

}
