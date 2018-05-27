package com.mojita.integration.core.datasource.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.mojita.integration.core.datasource.DataBaseContextHolder;
import com.mojita.integration.core.datasource.annotations.ReadOnlyConnection;

/**
 * @author lijunhong
 * @since 18/5/28 上午1:00
 * 通过aop处理只读注解内容，动态切换数据源
 */
@Aspect
@Component
public class ReadOnlyConnectionInterceptor implements Ordered {


    @Around("@annotation(readOnlyConnection)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint, ReadOnlyConnection readOnlyConnection) throws Throwable {

        try {
            System.out.println("注册mysql slave");
            DataBaseContextHolder.setDatabaseType(DataBaseContextHolder.DataBaseType.MYSQLSLAVEONE);
            Object result = proceedingJoinPoint.proceed();
            System.out.println("完成mysql slave");
            return result;
        } finally {
            DataBaseContextHolder.clearDataBaseType();
        }

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
