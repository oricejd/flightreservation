package com.ap.learnspringboot.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ap.learnspringboot.flightreservation.dto.ReservationRequest;
import com.ap.learnspringboot.flightreservation.entities.Flight;
import com.ap.learnspringboot.flightreservation.entities.Reservation;
import com.ap.learnspringboot.flightreservation.repos.FlightRepository;
import com.ap.learnspringboot.flightreservation.services.ReservationService;

@Controller
public class ReservationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

	@Autowired
	FlightRepository flightRepsitory;

	@Autowired
	ReservationService reservationService;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		LOGGER.info("Inside showCompleteReservation invoked with: " + flightId);
		Flight flight = flightRepsitory.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		LOGGER.info("Flight is: " + flight);
		return "completeReservation";
	}

	@RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		LOGGER.info("Inside completeReservation invoked with: " + request);
		Reservation reservation = reservationService.reservationBookFlight(request);
		modelMap.addAttribute("msg", "Reservation created successfully with id: " + reservation.getId());
		return "reservationConfirmation";
	}

}
