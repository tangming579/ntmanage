package com.tm.mall.service.impl;

import com.tm.mall.mbg.mapper.PmsBrandMapper;
import com.tm.mall.mbg.model.PmsBrand;
import com.tm.mall.mbg.model.PmsBrandExample;
import com.tm.mall.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    @Autowired
    PmsBrandMapper mapper;

    @Override
    public List<PmsBrand> listAllBrand() {

        var example=new PmsBrandExample();
        var criteria=example.createCriteria();
        return mapper.selectByExample(example);
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return 0;
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        return 0;
    }

    @Override
    public int deleteBrand(Long id) {
        return 0;
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return null;
    }
}
