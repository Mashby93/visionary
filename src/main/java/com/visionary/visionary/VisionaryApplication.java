package com.visionary.visionary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = "com.visionary.visionary")
public class VisionaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(VisionaryApplication.class, args);
	}

}
