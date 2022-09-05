package com.studentadmin.studentadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentadminApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentadminApplication.class, args);

		System.out.println("Application is runing on Port:8080");
	}

}
