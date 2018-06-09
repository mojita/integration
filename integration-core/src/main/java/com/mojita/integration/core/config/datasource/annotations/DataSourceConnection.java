package com.mojita.integration.core.config.datasource.annotations;

import java.lang.annotation.*;

import com.mojita.integration.core.config.datasource.DataBaseContextHolder;

/**
 * @author lijunhong
 * @since 18/6/8 下午10:55
 * 用于自动切换数据源
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSourceConnection {


    DataBaseContextHolder.DataBaseType value() default DataBaseContextHolder.DataBaseType.POSTGRES;

}
