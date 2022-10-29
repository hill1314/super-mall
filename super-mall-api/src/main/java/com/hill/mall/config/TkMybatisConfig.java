package com.hill.mall.config;

import org.springframework.context.annotation.Configuration;

/**
 * MybatisMapperConfig
 *
 * @Author huleilei9
 * @Date 2022/10/29
 **/
@tk.mybatis.spring.annotation.MapperScan(basePackages = {"com.hill.**.mapper"})
@Configuration
public class TkMybatisConfig {

}
