package com.example.Backend;


import com.example.Backend.repo.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//one
@ImportResource("Beans.xml")
@EnableMongoRepositories
@SpringBootApplication()
public class BackendApplication {
    @Autowired
    PersonaRepo roleRepo;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
        System.out.println("class started");
    }

}
