package com.mojita.integration.core.datasource;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author lijunhong
 * @since 18/5/27 下午6:27
 */
@Configuration
@AutoConfigureAfter({DataSourceConfiguration.class})
public class MybatisConfiguration extends MybatisAutoConfiguration {


    @Resource(name = "postgresDataSource")
    private DataSource postgresDataSource;
    @Resource(name = "mysqlMasterDataSource")
    private DataSource mysqlMasterDataSource;
    @Resource(name = "mysqlSlaveOneDataSource")
    private DataSource mysqlSlaveOneDataSource;


    public MybatisConfiguration(MybatisProperties properties, ObjectProvider<Interceptor[]> interceptorsProvider,
                                ResourceLoader resourceLoader, ObjectProvider<DatabaseIdProvider> databaseIdProvider,
                                ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider) {

        super(properties, interceptorsProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider);
    }



    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() {
//        return super.sqlSessionFactory();
        return null;
    }

//    public AbstractRoutingDataSource routingDataSourceProxy() {
//        re
//    }

}
