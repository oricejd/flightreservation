package com.ap.learnspringboot.flightreservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ap.learnspringboot.flightreservation.controllers.FlightController;
import com.ap.learnspringboot.flightreservation.dto.ReservationRequest;
import com.ap.learnspringboot.flightreservation.entities.Flight;
import com.ap.learnspringboot.flightreservation.entities.Passenger;
import com.ap.learnspringboot.flightreservation.entities.Reservation;
import com.ap.learnspringboot.flightreservation.repos.FlightRepository;
import com.ap.learnspringboot.flightreservation.repos.PassengerRepository;
import com.ap.learnspringboot.flightreservation.repos.ReservationRepository;
import com.ap.learnspringboot.flightreservation.util.EmailUtil;
import com.ap.learnspringboot.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Value("${com.ap.learnspringboot.flightreservation.itinerary.dirpath}")
	private String ITINERARY_DIR;

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PDFGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;

	@Override
	public Reservation reservationBookFlight(ReservationRequest request) {
		//make payment
		
		LOGGER.info("Inside reservationBookFlight");
		Long flightId = request.getFlightId();
		LOGGER.info("Fetching flight for flight id: " + flightId);
		Flight flight = flightRepository.findById(flightId).get();
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		
		LOGGER.info("Saving the passenger: " + passenger);
		Passenger savedPassenger = passengerRepository.save(passenger); 
		
		Reservation reservation =new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		 
		LOGGER.info("Saving the reservation: " + reservation);
		Reservation savedReservation = reservationRepository.save(reservation);
		
		String filePath = ITINERARY_DIR + savedReservation.getId() + ".pdf";
		LOGGER.info("Generating the itinerary");
		pdfGenerator.generateItinerary(reservation, filePath );
		
		LOGGER.info("Sending email");
		emailUtil.sendItineraryEmail(passenger.getEmail(), filePath);
		
		return savedReservation;
	}

}
