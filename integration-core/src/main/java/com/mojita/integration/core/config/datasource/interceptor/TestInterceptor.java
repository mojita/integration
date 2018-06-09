package com.mojita.integration.core.config.datasource.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author lijunhong
 * @since 18/6/8 下午11:12
 */
@Aspect
@Component
public class TestInterceptor {

    @Pointcut("execution(public * com.mojita.integration.core.service.*.*(..))")
    public void log() {
        System.out.println("打个日志庆祝下");
    }


    @Before(value = "log()")
    public void begin(JoinPoint joinPoint) {
        System.out.println("这是个啥原理");
    }

}
