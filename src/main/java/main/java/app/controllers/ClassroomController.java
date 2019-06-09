package main.java.app.controllers;

import main.java.app.exceptions.ResourceNotFoundException;
import main.java.app.models.Classroom;
import main.java.app.models.User;
import main.java.app.repositories.ClassroomRepo;
import main.java.app.repositories.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/classrooms")
public class ClassroomController {
    // Edit classroom: change teacher, add or remove students

    private final ClassroomRepo repo;
    private final UserRepo userRepo;

    public ClassroomController(ClassroomRepo repo, UserRepo userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    // Create classroom
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Classroom createClassroom(@RequestBody Classroom classroom) {
        return repo.save(classroom);
    }

    // Get classroom
    @GetMapping("/{id}")
    public Classroom getClassroom(@PathVariable(value = "id") String id) {
        return repo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    // Add student
    @PutMapping("/{id}/add")
    public Classroom addStudent(@PathVariable(value = "id") String id, @RequestBody Classroom updatedClassroom) {
        Classroom classroom = repo.findById(id).orElseThrow(ResourceNotFoundException::new);
        classroom.setStudents(updatedClassroom.getStudents());
        return repo.save(classroom);
    }

    // Get all classrooms of one teacher
    @GetMapping("/all/{id}")
    public List<Classroom> getAllClassrooms(@PathVariable String id) {
        User teacher = userRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
        return repo.findAllByTeacher(teacher);
    }
}
