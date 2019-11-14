package com.ap.learnspringboot.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ap.learnspringboot.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	//query created by Spring Data JPA based on the naming convention
	// findBy<Email> ---> <email> --- email field in the User table
	User findByEmail(String email);

}
