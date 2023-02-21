package com.example.Backend;

import model.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@ImportResource("classpath:beans.xml")
@EnableAutoConfiguration
@EnableMongoRepositories
@SpringBootApplication
public class BackendApplication implements CommandLineRunner {
	@Autowired
	UserRepo repository;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		System.out.println("user inserted");
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new User(1, 01, "muskan.singh@nagarro.com", "password", "muskan", true));
		System.out.println("user inserted");

	}
}
