package com.example.headstart;

import java.util.*;

public class Education {
	
	//Data
	
	private int age;
	private String year;
	private String level;  //high school, college, "" for either
	
	
	//Constructors
	
	public Education() {
		age = 0;
		year = "";
		level = "";
	}
	
	public Education(int age, String year, String level) {
		this.age = age;
		this.year = year;
		this.level = level;
	}
	
	//Methods

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

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
