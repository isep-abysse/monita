package main.java.app.repositories;

import main.java.app.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends MongoRepository<User, String> {

    User findByEmail(String email);

    Optional<User> findById(String id);

    List<User> findAllByRole(String role);
}