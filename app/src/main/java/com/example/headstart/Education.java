package com.example.headstart;

import java.util.*;

public class Education {
	
	//Data

	private String year;
	private String level;  //high school, college, "" for either
	
	
	//Constructors
	
	public Education() {
		year = "";
		level = "";
	}
	
	public Education(String year, String level) {
		this.year = year;
		this.level = level;
	}
	
	//Methods

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}	
	
}
