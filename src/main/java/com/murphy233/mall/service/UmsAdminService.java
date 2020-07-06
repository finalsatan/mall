package com.murphy233.mall.service;

import com.murphy233.mall.mbg.model.UmsAdmin;
import com.murphy233.mall.mbg.model.UmsPermission;

import java.util.List;

/**
 * UmsAdminService
 * 后台管理员 Service
 *
 * @author zhangyh2360@dimpt.com
 * @date 2020/7/6 9:31 上午
 */
public interface UmsAdminService {
    /**
     * 根据用户名获取后台管理员
     * @param username 用户名
     * @return 管理员账户
     */
    UmsAdmin getAdminByUserName(String username);

    /**
     * 注册
     * @param umsAdminParam 注册参数
     * @return 管理员账户
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 生成的 JWT 的 Token
     */
    String login(String username, String password);

    /**
     * 获取用户的所有权限
     * @param adminId 管理员 id
     * @return 权限列表
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
