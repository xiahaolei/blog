package com.xiahl.blog.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户模型
 * @author Louis
 * @date Jun 29, 2019
 */
@Data
public class SysUser {

	@ApiModelProperty("主键ID")
    private Long id;

	@ApiModelProperty("用户名")
    private String username;

	@ApiModelProperty("密码")
    private String password;

	@ApiModelProperty("记住我")
    private Integer rememberMe;

}