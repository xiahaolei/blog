package com.xiahl.blog.security.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 登录接口封装对象
 * @author Louis
 * @date Jun 29, 2019
 */
@Data
public class LoginRequest {

	@ApiModelProperty(value = "用户名")
	private String username;

	@ApiModelProperty(value = "密码")
	private String password;

	@ApiModelProperty(value = "手机号")
	private String phoneNum;

	@ApiModelProperty(value = "记住我")
	private Boolean rememberMe = false;

	
}
