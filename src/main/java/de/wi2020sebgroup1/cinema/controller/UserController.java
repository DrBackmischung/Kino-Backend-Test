package de.wi2020sebgroup1.cinema.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.wi2020sebgroup1.cinema.assembler.UserAssembler;
import de.wi2020sebgroup1.cinema.exception.UserNotFoundException;
import de.wi2020sebgroup1.cinema.model.User;
import de.wi2020sebgroup1.cinema.repo.UserRepo;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private final UserRepo REPOSITORY;

    private final UserAssembler ASSEMBLER;

    public UserController(UserRepo REPOSITORY, UserAssembler ASSEMBLER) {
        this.REPOSITORY = REPOSITORY;
        this.ASSEMBLER = ASSEMBLER;
    }
	
	@GetMapping("/users")
	public
    ResponseEntity<?> all() {

        List<EntityModel<User>> users = REPOSITORY.findAll().stream()
                .map(ASSEMBLER::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<User>> entityModels = CollectionModel.of(users, linkTo(methodOn(UserController.class).all()).withSelfRel());

        return ResponseEntity.ok(entityModels);
    }

    @GetMapping("/users/{id}")
	public
    ResponseEntity<?> one(@PathVariable long id) {

    	User user = REPOSITORY.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Not found: "+id));

        EntityModel<User> snackEntityModel = ASSEMBLER.toModel(user);

        return ResponseEntity.ok(snackEntityModel);
    }
	
}
