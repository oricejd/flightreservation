package com.ap.learnspringboot.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ap.learnspringboot.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
