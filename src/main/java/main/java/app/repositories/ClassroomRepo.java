package main.java.app.repositories;

import main.java.app.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import main.java.app.models.Classroom;

import java.util.List;
import java.util.Optional;

public interface ClassroomRepo extends MongoRepository<Classroom, String> {

    Optional<Classroom> findById(String id);

    /*List<*/Classroom findAllByTeacher(User teacher);

}