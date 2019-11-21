package com.ap.learnspringboot.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ap.learnspringboot.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
