package com.murphy233.mall.controller;

import com.murphy233.mall.common.api.CommonResult;
import com.murphy233.mall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 会员登录注册管理Controller
 *
 * @author zhangyh2360@dimpt.com
 * @date 2020/4/1 10:38 下午
 */
@Api(tags = {"会员登录注册管理"}, value = "UmsMemberController")
@Controller
@RequestMapping("/sso")
public class UmsMemberController {
    private final UmsMemberService memberService;

    public UmsMemberController(UmsMemberService memberService) {
        this.memberService = memberService;
    }

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam @ApiParam("手机号") String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@RequestParam @ApiParam("手机号") String telephone,
                                       @RequestParam @ApiParam("验证码") String authCode) {
        return memberService.verifyAuthCode(telephone, authCode);
    }
}