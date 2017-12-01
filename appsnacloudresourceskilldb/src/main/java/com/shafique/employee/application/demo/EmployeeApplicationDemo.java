package com.shafique.employee.application.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.shafique.employee.repositories")
@ComponentScan("com.shafique.employee")
public class EmployeeApplicationDemo {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplicationDemo.class, args);
	}

}
