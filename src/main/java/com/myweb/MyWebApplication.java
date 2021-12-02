package com.myweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableCaching
@SpringBootApplication()
public class MyWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyWebApplication.class, args);
	}
}
