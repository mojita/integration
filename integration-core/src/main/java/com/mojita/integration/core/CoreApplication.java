package com.mojita.integration.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//(exclude = {DataSourceAutoConfiguration.class})(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableAutoConfiguration
@MapperScan(basePackages = {"com.mojita.integration.core.dao"})
//@MapperScan(basePackages = {"com.mojita.integration.core.dao"})
@ComponentScan(basePackages = {"com.mojita.integration.core"})
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}
}

