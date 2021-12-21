package com.athensoft.prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.athensoft.prototype.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class PrototypeSpringOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(PrototypeSpringOauth2Application.class, args);
	}

}
