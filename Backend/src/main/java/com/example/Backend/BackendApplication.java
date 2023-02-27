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
@EnableAutoConfiguration
@EnableMongoRepositories
//@ImportResource("classpath:Beans.xml")
@SpringBootApplication
public class BackendApplication {
	@Autowired
	UserRepo repository;
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		System.out.println("class started");
	}


//	@Override
//	public void run(String... args) throws Exception {
//     //save a couple of customers
//	repository.save(new User(1, 01, "muskan@nagarro.com", "password", "muskan", true));
//		System.out.println("user inserted");
//
//		repository.save(new User(2, 02, "kanishka01@nagarro.com", "password", "kanishka", true));
//		System.out.println("user inserted");
//	}


}
