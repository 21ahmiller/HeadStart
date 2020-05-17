package com.example.headstart;

import java.util.*;

public class Job {

	//Data

	private String jobTitle;
	private String jobType;
	private String jobDescription;
	private String address;
	private String state;
	private String city;
	private String zipcode;
	private String requirements;
	private String skills;
	private String schedule;
	private String salary;
	private String benefits;
	private String ageMinimum;
	private String school;
	private ArrayList<String> keywords;
	private String companyID;


	//Constructors

	public Job() {
		this.jobTitle = "";
		this.jobType = "";
		this.jobDescription = "";
		this.requirements = "";
		this.skills = "";
		this.schedule = "";
		this.salary = "";
		this.benefits = "";
		this.ageMinimum = "";
		this.keywords = new ArrayList<String>();
		this.companyID = "";
		this.school = "";
		this.address = "";
		this.state = "";
		this.city = "";
		this.zipcode = "";
	}

	public Job(String jobTitle, String jobType, String jobDescription, String state, String city, String zipCode, String address, String requirements,
			   String skills, String schedule, String salary, String benefits, String ageMinimum, String school, String companyID) {
		this.jobTitle = jobTitle;
		this.jobType = jobType;
		this.jobDescription = jobDescription;
		this.address = address;
		this.state = state;
		this.city = city;
		this.zipcode = zipCode;
		this.requirements = requirements;
		this.skills = skills;
		this.schedule = schedule;
		this.salary = salary;
		this.benefits = benefits;
		this.ageMinimum = ageMinimum;
		this.school = school;
		this.keywords = new ArrayList<String>();
		this.companyID = companyID;
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

	public ArrayList<String> getKeywords() {
		return keywords;
	}

	public void addKeyword(String keyword) {
		this.keywords.add(keyword);
	}

	public void removeKeyword(String keyword){
		this.keywords.remove(keyword);
	}

	public String getAddress(){
		return address;
	}
	public String getState(){
		return state;
	}
	public String getCity(){
		return city;
	}
	public String getZipcode(){
		return zipcode;
	}
	public String getSchool(){
		return school;
	}

	public void setState(String state){
		this.state = state;
	}
	public void setCity(String city){
		this.city = city;
	}
	public void setZipcode(String zipcode){
		this.zipcode = zipcode;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public void setSchool(String school){
		this.school = school;
	}


	public String getCompanyID(){
		return companyID;
	}

	public void setCompanyID(String companyID){
		this.companyID = companyID;
	}

	public String arrayToString(ArrayList<String> keywords){
		String string = "";
		for(int i = 0; i < keywords.size() - 1; i ++){
			string = string + keywords.get(i) + ", ";
		}
		string = string + keywords.get(keywords.size() - 1);
		return string;
	}
	@Override
	public String toString(){
		return jobTitle + "\n" + jobType + "\n" + address + " " + city + ", " + state + "\n" + "Salary: $" + salary + " per hour" + "\n" + "Keywords: \n" + arrayToString(keywords);
	}
}
