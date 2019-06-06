package main.java.app.controllers;

import main.java.app.exceptions.ResourceNotFoundException;
import main.java.app.models.Classroom;
import main.java.app.repositories.ClassroomRepo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {
    // Edit classroom: change teacher, add or remove students

    private final ClassroomRepo repo;

    public ClassroomController(ClassroomRepo repo) {
        this.repo = repo;
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
}
