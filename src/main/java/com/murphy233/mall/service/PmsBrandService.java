package com.murphy233.mall.service;

import com.murphy233.mall.mbg.model.PmsBrand;

import java.util.List;

/**
 * PmsBrandService
 *
 * @author zhangyh2360@dimpt.com
 * @date 2020/4/1 12:11 上午
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
