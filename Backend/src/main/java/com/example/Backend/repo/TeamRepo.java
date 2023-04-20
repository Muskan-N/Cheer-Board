package com.example.Backend.repo;

import com.example.Backend.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
@Repository
public interface TeamRepo extends MongoRepository<Team, String> {
    //Returns user using Team
    Team findByTeamName(String teamName);
    Team findByTeamId(int teamId);
}
