package com.example.Backend;

import com.example.Backend.model.User;
import com.example.Backend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//one
@ImportResource("classpath:beans.xml")
@EnableAutoConfiguration
@EnableMongoRepositories
@SpringBootApplication
public class BackendApplication {
	@Autowired
	UserRepo repository;
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		System.out.println("class started");
	}

}
