package com.mojita.integration.core.config.datasource.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.mojita.integration.core.config.datasource.DataBaseContextHolder;
import com.mojita.integration.core.config.datasource.annotations.DataSourceConnection;

/**
 * @author lijunhong
 * @since 18/6/8 下午10:58
 * 通过aop进行拦截请求
 */
@Aspect
@Component
public class DataSourceInterceptor implements Ordered {


    @Around("@annotation(dataSourceConnection)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint, DataSourceConnection dataSourceConnection) throws Throwable{
        try {
            DataBaseContextHolder.setDatabaseType(dataSourceConnection.value());
            Object result = proceedingJoinPoint.proceed();
            return result;
        }finally {
            DataBaseContextHolder.clearDataBaseType();
        }
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
