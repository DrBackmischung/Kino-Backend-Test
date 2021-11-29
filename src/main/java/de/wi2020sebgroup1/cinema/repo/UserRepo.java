package de.wi2020sebgroup1.cinema.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.wi2020sebgroup1.cinema.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	
	
	
}
