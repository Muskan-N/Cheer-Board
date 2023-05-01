package com.example.Backend.repo;

import com.example.Backend.model.Certification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
@Repository
public interface CertificationRepo extends MongoRepository<Certification, String> {
    Certification findByCertificationId(int certificationId);

    Certification findByCertificationName(String certificationName);

}
