package main.java.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import main.java.app.models.Classroom;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClassroomRepo extends MongoRepository<Classroom, String> {

    @Override
    List<Classroom> findAll();

    Optional<Classroom> findById(String id);

    @Query(" { 'teachers': ?0 } ")
    List<Classroom> findAllByTeacher(String teacherId);
}