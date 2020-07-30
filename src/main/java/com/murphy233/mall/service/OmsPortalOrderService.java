package com.murphy233.mall.service;

import com.murphy233.mall.common.api.CommonResult;
import com.murphy233.mall.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * 前台订单管理 service
 *
 * @author zhangyh2360@dimpt.com
 * @date 2020/7/29 5:07 下午
 */
public interface OmsPortalOrderService {
    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);
}
