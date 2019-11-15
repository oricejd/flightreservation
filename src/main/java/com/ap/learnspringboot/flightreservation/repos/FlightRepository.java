package com.ap.learnspringboot.flightreservation.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ap.learnspringboot.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	// :=departureCity - has the same name as the attribute in the flight entity class
	@Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
	List<Flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to,
			@Param("dateOfDeparture") Date departureDate);
	
	@Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity")
	List<Flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to);

}
