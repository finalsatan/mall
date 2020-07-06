package com.murphy233.mall.dto;


import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

/**
 * UmsAdminLoginParam
 * 用户登录参数
 *
 * @author zhangyh2360@dimpt.com
 * @date 2020/7/6 4:36 下午
 */
public class UmsAdminLoginParam {
    @ApiModelProperty(value="用户名", required = true)
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value="密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
