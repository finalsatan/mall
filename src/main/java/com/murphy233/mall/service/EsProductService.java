package com.murphy233.mall.service;

import com.murphy233.mall.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * EsProductService
 * 商品搜索管理 Service
 *
 * @author zhangyh2360@dimpt.com
 * @date 2020/7/8 11:24 上午
 */
public interface EsProductService {
    /**
     * 从数据库中导入所有商品到ES
     * @return 商品数量
     */
    int importAll();

    /**
     * 根据id删除商品
     * @param id 商品id
     */
    void delete(Long id);

    /**
     * 根据id创建商品
     * @param id 商品id
     * @return elasticsearch product
     */
    EsProduct create(Long id);

    /**
     * 根据id批量删除商品
     * @param ids 商品id列表
     */
    void delete(List<Long> ids);

    /**
     * 根据关键字搜索名称或者副标题
     * @param keyword 关键字
     * @param pageNum 页码
     * @param pageSize 数量
     * @return 商品
     */
    Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);
}
