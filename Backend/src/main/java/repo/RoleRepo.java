package repo;

import model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepo extends MongoRepository<Role,String> {
    Role findByRole(String role);
}
