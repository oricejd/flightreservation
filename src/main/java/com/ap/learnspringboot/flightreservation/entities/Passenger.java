package com.ap.learnspringboot.flightreservation.entities;

import javax.persistence.Entity;

@Entity
public class Passenger extends AbstractEntity{
	
	private String firstName;
	private String lastName;
	private String email;
	private String middleName;
	private String phone;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Passenger [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", middleName="
				+ middleName + ", phone=" + phone + "]";
	}

}
