package com.ap.learnspringboot.flightreservation.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ap.learnspringboot.flightreservation.entities.Flight;
import com.ap.learnspringboot.flightreservation.repos.FlightRepository;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepsitory;

	@RequestMapping("showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		Optional<Flight> flight = flightRepsitory.findById(flightId);
		modelMap.addAttribute("flight", flight);

		return "completeReservation";
	}

}
