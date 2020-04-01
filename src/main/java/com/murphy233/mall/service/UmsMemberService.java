package com.murphy233.mall.service;

import com.murphy233.mall.common.api.CommonResult;

/**
 * 会员管理Service
 *
 * @author zhangyh2360@dimpt.com
 * @date 2020/4/1 10:40 下午
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     *
     * @param telephone 手机号
     * @return 通用结果
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     *
     * @param telephone 手机号
     * @param authCode 验证码
     * @return 通用结果
     */
    CommonResult verifyAuthCode(String telephone, String authCode);

}