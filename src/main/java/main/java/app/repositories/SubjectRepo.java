package main.java.app.repositories;

import main.java.app.models.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubjectRepo extends MongoRepository<Subject, String> {

}
