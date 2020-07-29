package com.murphy233.mall.dao;

import com.murphy233.mall.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * EsProductDao
 * 搜索系统中的商品管理自定义 Dao
 *
 * @author zhangyh2360@dimpt.com
 * @date 2020/7/29 9:40 上午
 */
public interface EsProductDao {
    /**
     * getAllEsProductList
     * @param id id
     * @return ES 商品列表
     */
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
