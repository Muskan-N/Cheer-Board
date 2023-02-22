package com.example.Backend;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@EnableMongoRepositories
@SpringBootApplication
public class BackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		System.out.println("class started");
	}

//	@Override
//	public void run(String... args) throws Exception {
//		// save a couple of customers
//		repository.save(new User(1, 01, "muskan.singh@nagarro.com", "password", "muskan", true));
//		System.out.println("user inserted");
//
//	}
}

//how to insert data in mongo using entity