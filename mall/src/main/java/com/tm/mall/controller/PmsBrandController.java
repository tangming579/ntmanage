package com.tm.mall.controller;

import com.tm.mall.common.api.CommonPage;
import com.tm.mall.common.api.CommonResult;
import com.tm.mall.mbg.model.PmsBrand;
import com.tm.mall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/brand")
@Api(tags = "商品品牌管理")
@Slf4j
public class PmsBrandController {

    @Autowired
    private PmsBrandService brandService;

    @ApiOperation("获取所有品牌列表")
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(brandService.listAllBrand());
    }

    @ApiOperation("分页获取品牌列表")
    @RequestMapping(value = "getBrandListByPage", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<List<PmsBrand>>> getBrandListByPage(int pageNum, int pageSize) {
        return CommonResult.success(brandService.listPageBrand(pageNum, pageSize));
    }

    @ApiOperation("创建品牌")
    @RequestMapping(value = "createBrand", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createBrand(PmsBrand brand) {
        CommonResult result;
        int count = brandService.createBrand(brand);
        if (count == 1) {
            result = CommonResult.success(brand);
        } else {
            result = CommonResult.failed("创建失败");
        }
        return result;
    }

    @ApiOperation("删除品牌")
    @RequestMapping(value = "deleteBrand", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult deleteBrand(Long id) {
        CommonResult result;
        int count = brandService.deleteBrand(id);
        if (count == 1) {
            result = CommonResult.success(null);
        } else {
            result = CommonResult.failed("操作失败");
        }
        return result;
    }

    @ApiOperation("更新品牌")
    @RequestMapping(value = "updateBrand", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateBrand(PmsBrand brand) {
        CommonResult result;
        int count = brandService.updateBrand(brand.getId(), brand);
        if (count == 1) {
            result = CommonResult.success(null);
        } else {
            result = CommonResult.failed("操作失败");
        }
        return result;
    }

    @ApiOperation("获取指定品牌详情")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult brand(Long id){
        log.info("获取指定品牌详情，id={}",id);
        PmsBrand brand = brandService.getBrand(id);
        return CommonResult.success(brand);
    }
}
