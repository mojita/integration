package com.mojita.integration.core.config.datasource;

import java.util.Properties;
import javax.sql.DataSource;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.support.http.WebStatFilter;

/**
 * @author lijunhong
 * @since 18/5/27 下午5:43
 * DataSource相关配置信息
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {

    @Value("${druid.type}")
    private Class<? extends DataSource> dataSourceType;

    @Primary
    @Bean(name = "postgresDataSource")
    @ConfigurationProperties(prefix = "druid.postgres")
    public DataSource postgresDataSource() {
        DataSource postgresDataSource = DataSourceBuilder.create().type(dataSourceType).build();
        System.out.println("============postgres==============="+postgresDataSource);
        return postgresDataSource;
    }



    @Bean(name = "mysqlMasterDataSource")
    @ConfigurationProperties(prefix = "druid.mysqlmaster")
    public DataSource mysqlMasterDataSource() {
        DataSource mysqlMasterDataSource = DataSourceBuilder.create().type(dataSourceType).build();
        System.out.println("=============mysqlMaster" + mysqlMasterDataSource);
        return mysqlMasterDataSource;
    }


    @Bean(name = "mysqlSlaveOneDataSource")
    @ConfigurationProperties(prefix = "druid.mysqlslaveone")
    public DataSource mysqlSlaveDataSource() {
        DataSource mysqlSlaveDataSource = DataSourceBuilder.create().type(dataSourceType).build();
        System.out.println("=============msyqlSlave" + mysqlSlaveDataSource);
        return mysqlSlaveDataSource;
    }


    /**
     * 注入数据库别名
     * TODO 这里暂时还不支持，有时间再弄
     * @return
     */
    @Bean
    public DatabaseIdProvider getDataBaseIdProvider() {
        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
        Properties p = new Properties();
        p.setProperty("Oracle","oracle");
        p.setProperty("MySql","mysql");
        p.setProperty("MariaDB","mariadb");
        p.setProperty("Postgres","postgres");
        databaseIdProvider.setProperties(p);
        return databaseIdProvider;
    }


    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        //这里通过druid-springboot-start进行注册监控数据库
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico, /druid/*");
        System.out.println("=================druid filter register :" + filterRegistrationBean);
        return filterRegistrationBean;
    }

}
