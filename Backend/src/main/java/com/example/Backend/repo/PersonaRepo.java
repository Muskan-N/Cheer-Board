package com.example.Backend.repo;

import com.example.Backend.model.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
@Repository
public interface PersonaRepo extends MongoRepository<Persona, String> {
    //Returns user using persona
    Persona findByPersonaName(String personaName);

    Persona findByPersonaId(int personaId);
}
