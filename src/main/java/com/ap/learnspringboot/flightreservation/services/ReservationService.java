package com.ap.learnspringboot.flightreservation.services;

import com.ap.learnspringboot.flightreservation.dto.ReservationRequest;
import com.ap.learnspringboot.flightreservation.entities.Reservation;

public interface ReservationService {
	public Reservation reservationBookFlight(ReservationRequest request);

}
