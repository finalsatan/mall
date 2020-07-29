package com.murphy233.mall.service;

import com.murphy233.mall.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

/**
 * MemberReadHistoryService
 * 会员浏览记录管理service
 *
 * @author zhangyh2360@dimpt.com
 * @date 2020/7/29 4:27 下午
 */
public interface MemberReadHistoryService {
    /**
     * 创建浏览记录
     * @param memberReadHistory 浏览记录
     * @return 结果
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     * @param ids 记录ids
     * @return 结果
     */
    int delete(List<String> ids);

    /**
     * 获取用户浏览历史记录
     * @param memberId 会员id
     * @return 浏览历史记录
     */
    List<MemberReadHistory> list(Long memberId);
}
