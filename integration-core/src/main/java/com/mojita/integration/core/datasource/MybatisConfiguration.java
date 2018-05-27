package com.mojita.integration.core.datasource;

import java.util.List;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

/**
 * @author lijunhong
 * @since 18/5/27 下午6:27
 */
@Configuration
@AutoConfigureAfter({DataSourceConfiguration.class})
public class MybatisConfiguration extends MybatisAutoConfiguration {


    public MybatisConfiguration(MybatisProperties properties, ObjectProvider<Interceptor[]> interceptorsProvider, ResourceLoader resourceLoader, ObjectProvider<DatabaseIdProvider> databaseIdProvider, ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider) {
        super(properties, interceptorsProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider);
    }
}
