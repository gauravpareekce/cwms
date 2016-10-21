package com.ycompany.cwms.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.ycompany.cwms.base.repository")
@EntityScan(basePackages="com.ycompany.cwms.base.entity")
public class CwmswebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CwmswebApplication.class, args);
	}
}
