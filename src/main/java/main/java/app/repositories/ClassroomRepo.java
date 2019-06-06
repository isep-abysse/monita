package main.java.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import main.java.app.models.Classroom;
import java.util.Optional;

public interface ClassroomRepo extends MongoRepository<Classroom, String> {

    Optional<Classroom> findById(String id);

}