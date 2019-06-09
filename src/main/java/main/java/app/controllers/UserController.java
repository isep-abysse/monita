package main.java.app.controllers;

import main.java.app.exceptions.ResourceNotFoundException;
import main.java.app.models.User;
import main.java.app.repositories.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepo repo;

    public UserController(UserRepo repo) {
        this.repo = repo;
    }
    // sign up, add or remove subject, change password or username

    // Create user (signup)
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return repo.save(user);
    }

    // Get all students
    @GetMapping
    public List<User> getAllUsers() {
        System.out.println("Getting all students");
        return repo.findAllByRole("student");
    }

    // Get user
    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        System.out.println("Getting user with id " + id);
        return repo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    // Delete user
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteUser(@PathVariable String id) {
        User user = repo.findById(id).orElseThrow(ResourceNotFoundException::new);
        repo.delete(user);
    }

    // Update marks
    @PutMapping("/{id}")
    public void addMarks(@PathVariable String id, @RequestBody User updatedUser) {
        User user = repo.findById(id).orElseThrow(ResourceNotFoundException::new);
        System.out.println(updatedUser.getSubjects());
        user.setSubjects(updatedUser.getSubjects());
        repo.save(user);
    }

}