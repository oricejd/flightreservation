package com.ap.learnspringboot.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ap.learnspringboot.flightreservation.dto.ReservationRequest;
import com.ap.learnspringboot.flightreservation.entities.Flight;
import com.ap.learnspringboot.flightreservation.entities.Passenger;
import com.ap.learnspringboot.flightreservation.entities.Reservation;
import com.ap.learnspringboot.flightreservation.repos.FlightRepository;
import com.ap.learnspringboot.flightreservation.repos.PassengerRepository;
import com.ap.learnspringboot.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public Reservation reservationBookFlight(ReservationRequest request) {
		//make payment
		
		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		
		Passenger savedPassenger = passengerRepository.save(passenger); 
		
		Reservation reservation =new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		 
		Reservation savedReservation = reservationRepository.save(reservation);
		
		return savedReservation;
	}

}