package com.tm.mall.controller;

import cn.hutool.json.JSONUtil;
import com.tm.mall.common.api.CommonPage;
import com.tm.mall.common.api.CommonResult;
import com.tm.mall.component.MallProperties;
import com.tm.mall.mbg.model.PmsBrand;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
@Api(tags = "测试接口")
public class DemoController {

    @Autowired
    private MallProperties config;

    @GetMapping("/")
    public CommonResult<MallProperties> index(){
        return CommonResult.success(config);
    }
}
