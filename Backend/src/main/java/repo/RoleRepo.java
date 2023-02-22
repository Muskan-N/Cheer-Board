package repo;

import model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
@Repository
public interface RoleRepo extends MongoRepository<Role,String> {
    Role findByRole(String role);
}
