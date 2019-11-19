package com.ap.learnspringboot.flightreservation.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ap.learnspringboot.flightreservation.entities.Flight;
import com.ap.learnspringboot.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);
	
	@Autowired
	FlightRepository flightRepository;

	@RequestMapping("/findFlights")
	public String findFlights(
			@RequestParam("from") String from, 
			@RequestParam("to") String to,
//			@RequestParam("departureDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date departureDate,
			ModelMap modelMap) {
		LOGGER.info("Inside findFlights: from-" + from + " to-" + to);
		
//		List<Flight> flights = flightRepository.findFlights(from,to,departureDate);
		List<Flight> flights = flightRepository.findFlights(from,to);
		modelMap.addAttribute("flights", flights);
		LOGGER.info("Fights found are: " + flights);
		return "displayFlights";
	}

}
