package de.wi2020sebgroup1.cinema.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.wi2020sebgroup1.cinema.model.User;
import de.wi2020sebgroup1.cinema.repo.UserRepo;

@RestController
@RequestMapping("api")
public class UserController {
	
	private UserRepo userRepo;
	
	@GetMapping("users")
	public List<User> getUsers() {
		return this.userRepo.findAll();
	}
	
}
