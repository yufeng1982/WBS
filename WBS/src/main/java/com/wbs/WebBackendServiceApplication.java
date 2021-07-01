package com.wbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.wbs.dao")
public class WebBackendServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebBackendServiceApplication.class, args);
	}

}
