package com.mojita.integration.core.datasource.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.mojita.integration.core.datasource.DataBaseContextHolder;
import com.mojita.integration.core.datasource.annotations.PostgresConnection;

/**
 * @author lijunhong
 * @since 18/5/28 上午1:33
 * 通过aop动态切换数据源为postgres
 */
@Aspect
@Component
public class PostgresConnectionInterceptor implements Ordered{


    @Around("@annotation(postgresConnection)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint, PostgresConnection postgresConnection) throws Throwable{

        try {
            System.out.println("注册postgres");
            DataBaseContextHolder.setDatabaseType(DataBaseContextHolder.DataBaseType.POSTGRES);
            Object result = proceedingJoinPoint.proceed();
            System.out.println("完成================postgres");
            return result;
        }finally {
            //执行完成之后清除当前数据源，保持默认数据源
            DataBaseContextHolder.clearDataBaseType();
        }
    }



    @Override
    public int getOrder() {
        return 0;
    }
}
