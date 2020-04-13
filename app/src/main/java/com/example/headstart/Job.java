package com.example.headstart;

import java.util.*;

public class Job {

	//Data

	private String jobTitle;
	private String jobType;
	private String jobDescription;
	private Location location;
	private String requirements;
	private String skills;
	private String schedule;
	private String salary;
	private String benefits;
	private String ageMinimum;


	//Constructors

	public Job() {
		this.jobTitle = "";
		this.jobType = "";
		this.jobDescription = "";
		this.location = new Location();
		this.requirements = "";
		this.skills = "";
		this.schedule = "";
		this.salary = "";
		this.benefits = "";
		this.ageMinimum = "";
	}

	public Job(String jobTitle, String jobType, String jobDescription, String state, String city, String zipcode, String requirements,
			   String skills, String schedule, String salary, String benefits, String ageMinimum) {
		this.jobTitle = jobTitle;
		this.jobType = jobType;
		this.jobDescription = jobDescription;
		this.location = new Location(state, city, zipcode);
		this.requirements = requirements;
		this.skills = skills;
		this.schedule = schedule;
		this.salary = salary;
		this.benefits = benefits;
		this.ageMinimum = ageMinimum;
	}

	//Methods

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(String state, String city, String zipcode) {
		this.location = new Location(state, city, zipcode);
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	public String getAgeMinimum() {
		return ageMinimum;
	}

	public void setAgeMinimum(String ageMinimum) {
		this.ageMinimum = ageMinimum;
	}
	@Override
	public String toString(){
		return jobTitle + "\n" + jobType + "\n" + location.toString() + "\n" + salary + "\n" + "Requirements: \n" + requirements;
	}
}
