package main.java.app.controllers;

import main.java.app.models.User;
import main.java.app.repositories.UserRepo;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepo repo;

    public AuthController(UserRepo repo) {
        this.repo = repo;
    }

    // Login
    @GetMapping("/{email}")
    public User getUser(@PathVariable String email) {
        System.out.println("Getting user with email " + email);
        return repo.findByUsername(email);
    }
}
