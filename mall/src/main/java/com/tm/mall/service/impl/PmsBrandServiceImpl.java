package com.tm.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.tm.mall.common.api.CommonPage;
import com.tm.mall.dto.PmsBrandParam;
import com.tm.mall.mbg.mapper.PmsBrandMapper;
import com.tm.mall.mbg.model.PmsBrand;
import com.tm.mall.mbg.model.PmsBrandExample;
import com.tm.mall.service.PmsBrandService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    @Autowired
    PmsBrandMapper mapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return mapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public CommonPage listPageBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PmsBrand> list = mapper.selectByExample(new PmsBrandExample());
        return CommonPage.restPage(list);
    }

    @Override
    public int createBrand(PmsBrandParam pmsBrandParam) {
        PmsBrand pmsBrand = new PmsBrand();
        BeanUtils.copyProperties(pmsBrandParam, pmsBrand);
        //如果创建时首字母为空，取名称的第一个为首字母
        if (StringUtils.isEmpty(pmsBrand.getFirstLetter())) {
            pmsBrand.setFirstLetter(pmsBrand.getName().substring(0, 1));
        }
        return mapper.insertSelective(pmsBrand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return mapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return mapper.selectByPrimaryKey(id);
    }
}
