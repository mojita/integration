package com.mojita.integration.core.datasource;

/**
 * @author lijunhong
 * @since 18/5/27 下午4:50
 * 配置多数据源枚举类型
 * 分别有三个数据源，一个是postgres和两个主从mysql
 */
public enum DatabaseType {
    POSTGRES,MYSQLMASTER,MYSQLSLAVEONE
}
