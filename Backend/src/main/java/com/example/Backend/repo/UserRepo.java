package com.example.Backend.repo;

import com.example.Backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
@Repository
public interface UserRepo extends MongoRepository<User, String> {
    //Returns user using email
    User findByEmail(String email);

    User findByEmpId(int empId);

}
