package com.mojita.integration.core.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lijunhong
 * @since 18/5/27 下午4:57
 * springboot集成mybatis
 * 1、创建数据源（如果使用tomcat-jdbc数据源，则不需要）
 * 2、创建sqlSessionFactory
 * 3、配置事务管理
 */
@Configuration
@MapperScan
public class MybatisConfig {

}
