package com.mojita.integration.core;

import org.springframework.context.annotation.Configuration;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author lijunhong
 * @since 18/5/27 下午11:55
 */
@MapperScan(basePackages = {"com.mojita.integration.core.common.basedao.BaseMapper"})
@Configuration
public class MainConfig {
}
