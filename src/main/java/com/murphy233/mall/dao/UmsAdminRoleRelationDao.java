package com.murphy233.mall.dao;

import com.murphy233.mall.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UmsAdminRoleRelationDao
 * 后台用户与角色管理自定义 Dao
 *
 * @author zhangyh2360@dimpt.com
 * @date 2020/7/6 10:35 上午
 */
public interface UmsAdminRoleRelationDao {
    /**
     * 获取用户所有权限
     * @param adminId 管理员用户id
     * @return 管理员用户权限
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
