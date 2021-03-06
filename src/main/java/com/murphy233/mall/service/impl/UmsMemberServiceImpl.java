package com.murphy233.mall.service.impl;

import com.murphy233.mall.common.api.CommonResult;
import com.murphy233.mall.service.RedisService;
import com.murphy233.mall.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * 会员管理Service实现类
 *
 * @author zhangyh2360@dimpt.com
 * @date 2020/4/1 10:42 下午
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    private final RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;
    @Value("${mall.authCode.length}")
    private Long AUTH_CODE_LENGTH;

    public UmsMemberServiceImpl(RedisService redisService) {
        this.redisService = redisService;
    }

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < AUTH_CODE_LENGTH; i++) {
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(sb.toString(), "获取验证码成功");
    }

    /**
     * 对输入的验证码进行校验
     *
     * @param telephone 手机号
     * @param authCode  验证码
     * @return 验证结果
     */
    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return CommonResult.failed("请输入验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            return CommonResult.success(null, "验证码校验成功");
        } else {
            return CommonResult.failed("验证码不正确");
        }
    }

}
