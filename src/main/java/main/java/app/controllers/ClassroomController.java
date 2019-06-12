package main.java.app.controllers;

import main.java.app.exceptions.ResourceNotFoundException;
import main.java.app.models.Classroom;
import main.java.app.repositories.ClassroomRepo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
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

    // Update classroom
    @PutMapping("/{id}")
    public Classroom update(@PathVariable String id, @RequestBody Classroom updatedClassroom) {
        Classroom classroom = repo.findById(id).orElseThrow(ResourceNotFoundException::new);
        classroom.setTeachers(updatedClassroom.getTeachers());
        return repo.save(classroom);
    }

    // Get all classrooms
    @GetMapping("/all")
    public List<Classroom> getAll() {
        return repo.findAll();
    }

    // Get all classrooms of one teacher
    @GetMapping("/all/{id}")
    public List<Classroom> getAllClassrooms(@PathVariable String id) {
        return repo.findAllByTeacher(id);
    }
}
