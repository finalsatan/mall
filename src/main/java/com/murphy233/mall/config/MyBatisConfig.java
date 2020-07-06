package com.murphy233.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 *
 * @author zhangyh2360@dimpt.com
 * @date 2020/4/1 12:05 上午
 */
@Configuration
@MapperScan({"com.murphy233.mall.mbg.mapper","com.murphy233.mall.dao"})
public class MyBatisConfig {
}
