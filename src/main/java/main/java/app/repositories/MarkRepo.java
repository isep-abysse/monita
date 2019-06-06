package main.java.app.repositories;

import main.java.app.models.Mark;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MarkRepo extends MongoRepository<Mark, String> {

}
