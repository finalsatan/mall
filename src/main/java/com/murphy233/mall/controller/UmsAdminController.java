package com.murphy233.mall.controller;

import com.murphy233.mall.common.api.CommonResult;
import com.murphy233.mall.dto.UmsAdminLoginParam;
import com.murphy233.mall.mbg.model.UmsAdmin;
import com.murphy233.mall.mbg.model.UmsPermission;
import com.murphy233.mall.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UmsAdminController
 * 后台用户管理
 *
 * @author zhangyh2360@dimpt.com
 * @date 2020/7/6 4:28 下午
 */
@Api(value = "UmsAdminController", tags = {"后台用户管理"})
@Controller
@RequestMapping("/admin")
public class UmsAdminController {
    private final UmsAdminService adminService;
    @Value("${mall.jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${mall.jwt.tokenHead")
    private String tokenHead;

    public UmsAdminController(UmsAdminService adminService) {
        this.adminService = adminService;
    }

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdminParam, BindingResult result) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            return CommonResult.failed("用户名已存在");
        }

        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsPermission>> getPermissionList(@PathVariable Long adminId) {
        List<UmsPermission> permissionList = adminService.getPermissionList(adminId);
        return CommonResult.success(permissionList);
    }

}
