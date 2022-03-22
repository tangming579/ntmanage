package com.tm.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.tm.mall.mbg.mapper")
public class MyBatisConfig {
}
