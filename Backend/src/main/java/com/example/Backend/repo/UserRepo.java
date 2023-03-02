package com.example.Backend.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.Backend.model.User;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;


@EnableMongoRepositories
@Repository
public interface UserRepo extends MongoRepository<User,String> {
    User findByEmail(String email);
    User findByToken(String token);

}
