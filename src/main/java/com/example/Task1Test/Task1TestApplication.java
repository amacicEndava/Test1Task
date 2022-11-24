package com.example.Task1Test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan("com.example.Task1Test.repositories.IUser")//to scan repository files
//@EntityScan("com.example.Task1Test.model.EmailDetails")
//@EnableJpaRepositories("com.example.Task1Test.repositories.IUser")
public class Task1TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Task1TestApplication.class, args);
	}

}
