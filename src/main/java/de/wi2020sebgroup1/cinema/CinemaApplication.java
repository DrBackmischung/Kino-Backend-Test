package de.wi2020sebgroup1.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.wi2020sebgroup1.cinema.model.User;
import de.wi2020sebgroup1.cinema.repo.UserRepo;

@SpringBootApplication
public class CinemaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
	}
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public void run(String... args) throws Exception {
		this.userRepo.save(new User("Mathis", "Neunzig", "mathis.neunzig@gmail.com"));
	}

}
