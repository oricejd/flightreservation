package com.ap.learnspringboot.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ap.learnspringboot.flightreservation.dto.ReservationUpadteRequest;
import com.ap.learnspringboot.flightreservation.entities.Reservation;
import com.ap.learnspringboot.flightreservation.repos.ReservationRepository;
import com.ap.learnspringboot.flightreservation.util.PDFGenerator;

@RestController
public class ReservationRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		LOGGER.info("Inside findReservation for id: " + id);
		return reservationRepository.getOne(id);
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpadteRequest request) {
		LOGGER.info("Inside updateReservation for : " + request);
		Reservation reservation = reservationRepository.getOne(request.getId());
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		LOGGER.info("Saving reservation");
		return reservationRepository.save(reservation);
	}

}
