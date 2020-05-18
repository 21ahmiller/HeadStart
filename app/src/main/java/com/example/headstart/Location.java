package com.example.headstart;

import java.util.*;

public class Location {
	
	//Data

	/**
	 * the state
	 */
	private String state;

	/**
	 * the city
	 */
	private String city;

	/**
	 * the zipcode
	 */
	private String zipCode;

	/**
	 * the postal address
	 */
	private String address;
	
	
	//Constructors

	/**
	 * the plain constructor that creates a Location object
	 */
	public Location() {
		state = "";
		city = "";
		zipCode = "";
		address = "";
	}

	/**
	 * Creates a location object
	 * @param state the state
	 * @param city the city
	 * @param zipCode the zipCode
	 * @param address the address
	 */
	public Location(String state, String city, String zipCode, String address) {
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.address = address;
	}
	
	//Methods

	/**
	 * returns the state
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * sets the state
	 * @param state the state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * returns the city
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * sets the city
	 * @param city the city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * returns the zipcode
	 * @return the zipcode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * sets the zipcode
	 * @param zipCode the zipcode
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * gets the address
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * sets the address
	 * @param address the address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Override of toString method; turns a location into a string
	 * @return the location string
	 */
	@Override
	public String toString(){
		if(!address.equals("") && !city.equals("") && !state.equals("") && !zipCode.equals("")){
			return address + " " + city + ", " + state + " " + zipCode;
		}else{
			return "";
		}
	}
	
}
