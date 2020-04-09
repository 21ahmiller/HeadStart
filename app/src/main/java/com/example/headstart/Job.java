package com.example.headstart;

import java.util.*;

public class Job {
		
	//Data
	
	private double wage;
	private String jobType;
	private Profile profile;
	
	//Constructors
	
	public Job() {
		wage = 0;
		jobType = new String();
		profile = new Profile();
	}
	
	public Job(double wage, String jobType) {
		this.wage = wage;
		this.jobType = jobType;
		profile = new Profile();
	}
	
	//Methods
	
	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public Profile getProfile() {
		return profile;
	}	
	
}
