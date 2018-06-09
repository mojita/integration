package com.mojita.integration.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
//@MapperScan(basePackages = {"com.mojita.integration.core.dao"})
@tk.mybatis.spring.annotation.MapperScan(basePackages = {"com.mojita.integration.core.dao"})
@ComponentScan(basePackages = {"com.mojita.integration.core"})
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}
}

