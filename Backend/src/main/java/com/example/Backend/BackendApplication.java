package com.example.Backend;


import com.example.Backend.model.Team;
import com.example.Backend.repo.RoleRepo;
import com.example.Backend.repo.TeamRepo;
import com.example.Backend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//one
@ImportResource("Beans.xml")
@EnableMongoRepositories
@SpringBootApplication()
public class BackendApplication{
		@Autowired
	RoleRepo roleRepo;
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		System.out.println("class started");
	}

}
