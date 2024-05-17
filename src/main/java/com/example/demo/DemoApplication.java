package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.example.controller")
@ComponentScan({"com.example.controller","com.example.service"})
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.repository")
public class DemoApplication {
	
		public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	
	}

}
