package com.example.Backend.repo;

import com.example.Backend.model.UpdatedUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
@Repository
public interface UpdatedUserRepo extends MongoRepository<UpdatedUser,String>  {
    UpdatedUser findByEmail(String email);
    UpdatedUser findByResetPasswordToken(String token);

}
