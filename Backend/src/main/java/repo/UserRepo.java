package repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import model.User;
public interface UserRepo extends MongoRepository<User,String> {
    User findByEmail(String email);

}
