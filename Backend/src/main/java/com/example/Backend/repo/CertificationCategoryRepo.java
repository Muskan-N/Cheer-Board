package com.example.Backend.repo;

import com.example.Backend.model.CertificationCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
@Repository
public interface CertificationCategoryRepo extends MongoRepository<CertificationCategory, String> {

    CertificationCategory findByCategoryId(int categoryId);

    CertificationCategory findByCategoryName(String categoryName);
}
