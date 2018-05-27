package com.mojita.integration.core.datasource.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.mojita.integration.core.datasource.DataBaseContextHolder;
import com.mojita.integration.core.datasource.annotations.ReadOrWriteConnection;

/**
 * @author lijunhong
 * @since 18/5/28 上午1:28
 * 通过aop实现数据源的动态切换，切换成mysql的主数据源
 */
@Aspect
@Component
public class ReadOrWriteConnectionInterceptor implements Ordered{



    @Around("@annotation(readOrWriteConnection)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint, ReadOrWriteConnection readOrWriteConnection) throws Throwable {

        try {
            System.out.println("注册mysql master");
            DataBaseContextHolder.setDatabaseType(DataBaseContextHolder.DataBaseType.MYSQLMASTER);
            Object result = proceedingJoinPoint.proceed();
            System.out.println("完成mysql master");
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
