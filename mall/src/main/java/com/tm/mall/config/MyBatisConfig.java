package com.tm.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created by macro on 2019/4/8.
 */
@Configuration
@MapperScan({"com.tm.mall.mbg.mapper","com.tm.mall.dao"})
public class MyBatisConfig {
}
