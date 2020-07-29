package com.murphy233.mall.nosql.mongodb.repository;

import com.murphy233.mall.nosql.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * MemberReadHistoryRepository
 * 会员商品浏览历史 repository
 *
 * @author zhangyh2360@dimpt.com
 * @date 2020/7/29 4:24 下午
 */
public interface MemberReadHistoryRepository  extends MongoRepository<MemberReadHistory,String> {
    /**
     * 根据会员id按时间倒序获取浏览记录
     * @param memberId 会员id
     * @return 会员浏览记录
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}
