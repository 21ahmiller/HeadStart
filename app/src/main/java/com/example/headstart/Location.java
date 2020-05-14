package com.example.headstart;

import java.util.*;

public class Location {
	
	//Data
	
	private String state;
	private String city;
	private String zipCode;
	private String address;
	
	
	//Constructors
	
	public Location() {
		state = "";
		city = "";
		zipCode = "";
		address = "";
	}
	
	public Location(String state, String city, String zipCode, String address) {
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString(){
		if(!address.equals("") && !city.equals("") && !state.equals("") && !zipCode.equals("")){
			return address + " " + city + ", " + state + " " + zipCode;
		}else{
			return "";
		}
	}
	
}
