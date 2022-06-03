package com.tm.mall.service;

import com.tm.mall.common.api.CommonPage;
import com.tm.mall.dto.PmsBrandParam;
import com.tm.mall.mbg.model.PmsBrand;

import java.util.List;

public interface PmsBrandService {

    List<PmsBrand> listAllBrand();

    CommonPage listPageBrand(int pageNum, int pageSize);

    int createBrand(PmsBrandParam brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    PmsBrand getBrand(Long id);
}
