package com.mojita.integration.core.datasource.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lijunhong
 * @since 18/5/28 上午1:24
 * 用来切mysql主数据源注解（可读写）
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReadOrWriteConnection {
}
