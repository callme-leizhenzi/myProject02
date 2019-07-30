package com.testdubbo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TestdubboWeb2Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TestdubboWeb2Application.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TestdubboWeb2Application.class);
	}
}
