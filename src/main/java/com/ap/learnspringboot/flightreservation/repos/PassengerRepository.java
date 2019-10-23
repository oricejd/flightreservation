package com.ap.learnspringboot.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ap.learnspringboot.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
