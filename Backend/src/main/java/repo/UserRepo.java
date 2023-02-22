package repo;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import model.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;


@EnableMongoRepositories
@Repository
public interface UserRepo extends MongoRepository<User,String> {
    User findByEmail(String email);

}
