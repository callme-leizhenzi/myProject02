package com.testdubbo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class TestdubboWeb1Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TestdubboWeb1Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TestdubboWeb1Application.class);
	}

}
