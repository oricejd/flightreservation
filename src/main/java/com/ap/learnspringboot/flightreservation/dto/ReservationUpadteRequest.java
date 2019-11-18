package com.ap.learnspringboot.flightreservation.dto;

public class ReservationUpadteRequest {

	private Long id;
	private int numberOfBags;

	public Long getId() {
		return id;
	}

	public Boolean getCheckedIn() {
		return checkedIn;
	}

	public int getNumberOfBags() {
		return numberOfBags;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}

	private Boolean checkedIn;

}
