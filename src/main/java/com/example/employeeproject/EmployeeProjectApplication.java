package com.example.employeeproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.employeeproject.Service.EmployeeService;
import com.example.employeeproject.Service.EmployeeServiceImp;

@SpringBootApplication
public class EmployeeProjectApplication {

	@Bean
	public EmployeeService employeeService() {
		return new EmployeeServiceImp();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeProjectApplication.class, args);
	}

}
