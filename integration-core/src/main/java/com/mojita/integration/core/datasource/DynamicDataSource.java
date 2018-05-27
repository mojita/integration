package com.mojita.integration.core.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author lijunhong
 * @since 18/5/27 下午4:27
 * 动态数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource{


    @Override
    protected Object determineCurrentLookupKey() {
        //获取当前线程中的DatabaseType
        return DatabaseContextHolder.getDatabaseType();
    }
}
