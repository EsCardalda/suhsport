package com.escaravellovermello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SuhsportApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SuhsportApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SuhsportApplication.class);
	}
	
}
