package de.wi2020sebgroup1.cinema.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.jetbrains.annotations.NotNull;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import de.wi2020sebgroup1.cinema.controller.UserController;
import de.wi2020sebgroup1.cinema.model.User;

@Component
public class UserAssembler implements RepresentationModelAssembler<User, EntityModel<User>>  { 
	
    public @NotNull EntityModel<User> toModel(@NotNull User user) {

        return EntityModel.of(user,
                linkTo(methodOn(UserController.class).one(user.getId())).withSelfRel(),
                linkTo(methodOn(UserController.class).all()).withRel("users"));
    }
	
}
