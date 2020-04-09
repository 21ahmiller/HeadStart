package com.example.headstart;

import java.util.*;

public class Location {
	
	//Data
	
	private String state;
	private String city;
	private String zipCode;
	
	
	//Constructors
	
	public Location() {
		state = "";
		city = "";
		zipCode = "";
	}
	
	public Location(String state, String city, String zipCode) {
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
	}
	
	//Methods

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
}
