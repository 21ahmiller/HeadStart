package com.example.headstart;

import java.util.*;

public class Education {
	
	//Data

	private String year;
	private String school;  //high school, college, "" for either
	
	
	//Constructors
	
	public Education() {
		year = "";
		school = "";
	}
	
	public Education(String year, String school) {
		this.year = year;
		this.school = school;
	}
	
	//Methods

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}	
	
}
