package com.murphy233.mall.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * OrderTimeOutCancelTask
 * 订单超时取消并解锁库存的定时器
 *
 * @author zhangyh2360@dimpt.com
 * @date 2020/7/7 3:20 下午
 */
@Component
public class OrderTimeOutCancelTask {
    private Logger LOGGER = LoggerFactory.getLogger(OrderTimeOutCancelTask.class);

    /**
     * cron表达式：seconds minutes hours dayOfMonth month dayOfWeek [year]
     * 每10分钟扫描一次，扫描设定超时时间之前下的订单，如果没有支付则取消该订单
     */
    @Scheduled(cron = "0 0/5 * ? * ?")
    private void cancelTimeOutOrder(){
        LOGGER.info("取消订单，并根据sku编号释放锁定库存");
    }




}
