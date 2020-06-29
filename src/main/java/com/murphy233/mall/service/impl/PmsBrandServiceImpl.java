package com.murphy233.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.murphy233.mall.mbg.mapper.PmsBrandMapper;
import com.murphy233.mall.mbg.model.PmsBrand;
import com.murphy233.mall.mbg.model.PmsBrandExample;
import com.murphy233.mall.service.PmsBrandService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PmsBrandService实现类
 *
 * @author zhangyh2360@dimpt.com
 * @date 2020/4/1 12:12 上午
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    private final PmsBrandMapper brandMapper;

    public PmsBrandServiceImpl(PmsBrandMapper brandMapper) {
        this.brandMapper = brandMapper;
    }

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}

