package de.wi2020sebgroup1.cinema.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.wi2020sebgroup1.cinema.exception.UserNotFoundException;
import de.wi2020sebgroup1.cinema.repo.UserRepo;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/users")
    public ResponseEntity<?> all() {
        return ResponseEntity.ok(userRepo.findAll());
    }

    @GetMapping("/users/{id}")
	public
    ResponseEntity<?> one(@PathVariable long id) {
        return ResponseEntity.ok(userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Not found: "+id)));
    }
	
}
