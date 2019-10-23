package com.ap.learnspringboot.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ap.learnspringboot.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
