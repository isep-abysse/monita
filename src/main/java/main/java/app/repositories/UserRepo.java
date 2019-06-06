package main.java.app.repositories;

import main.java.app.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User, String> {

    User findByUsername(String username);

    Optional<User> findById(String id);


}