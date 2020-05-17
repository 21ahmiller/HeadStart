package com.example.headstart;

import java.util.*;

public class Job {

	// Data for Job
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
	private String applicationURL;

	/**
	 * Creates an empty Job
	 */
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
		this.applicationURL = "";
	}

	/**
	 * Creates a job with given parameters
	 * @param jobTitle
	 * @param jobType
	 * @param jobDescription
	 * @param state
	 * @param city
	 * @param zipCode
	 * @param address
	 * @param requirements
	 * @param skills
	 * @param schedule
	 * @param salary
	 * @param benefits
	 * @param ageMinimum
	 * @param school
	 * @param applicationURL
	 * @param companyID
	 */
	public Job(String jobTitle, String jobType, String jobDescription, String state, String city, String zipCode, String address, String requirements,
			   String skills, String schedule, String salary, String benefits, String ageMinimum, String school, String applicationURL, String companyID) {
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
		this.applicationURL = applicationURL;
	}

	/**
	 * gets job's title
	 * @return jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * Sets jobTitle
	 * @param jobTitle
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * gets job's type
	 * @return jobType
	 */
	public String getJobType() {
		return jobType;
	}

	/**
	 * sets jobType
	 * @param jobType
	 */
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	/**
	 * gets job's description
	 * @return jobDescription
	 */
	public String getJobDescription() {
		return jobDescription;
	}

	/**
	 * sets jobDescription
	 * @param jobDescription
	 */
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	/**
	 * gets job's requirements
	 * @return requirements
	 */
	public String getRequirements() {
		return requirements;
	}

	/**
	 * sets requirements
	 * @param requirements
	 */
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	/**
	 * gets job's preferred skills
	 * @return skills
	 */
	public String getSkills() {
		return skills;
	}

	/**
	 * sets preferred skills
	 * @param skills
	 */
	public void setSkills(String skills) {
		this.skills = skills;
	}

	/**
	 * gets days for work
	 * @return schedule
	 */
	public String getSchedule() {
		return schedule;
	}

	/**
	 * sets days for work
	 * @param schedule
	 */
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	/**
	 * get hourly salary
	 * @return salary
	 */
	public String getSalary() {
		return salary;
	}

	/**
	 * set hourly salary
	 * @param salary
	 */
	public void setSalary(String salary) {
		this.salary = salary;
	}

	/**
	 * get job's benefits
	 * @return benefits
	 */
	public String getBenefits() {
		return benefits;
	}

	/**
	 * sets benefits
	 * @param benefits
	 */
	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	/**
	 * get minimum required age
	 * @return ageMinimum
	 */
	public String getAgeMinimum() {
		return ageMinimum;
	}

	/**
	 * sets minimum required age
	 * @param ageMinimum
	 */
	public void setAgeMinimum(String ageMinimum) {
		this.ageMinimum = ageMinimum;
	}

	/**
	 * gets arrayList of keywords
	 * @return
	 */
	public ArrayList<String> getKeywords() {
		return keywords;
	}

	/**
	 * sets URL to webpage for job application/information
	 * @param applicationURL
	 */
	public void setApplicationURL(String applicationURL){
		this.applicationURL = applicationURL;
	}

	/**
	 * gets URL for job's webpage
	 * @return applicationURL
	 */
	public String getApplicationURL(){
		return applicationURL;
	}

	/**
	 * get job's address
	 * @return address
	 */
	public String getAddress(){
		return address;
	}

	/**
	 * get job's state
	 * @return state
	 */
	public String getState(){
		return state;
	}

	/**
	 * get job's city
	 * @return city
	 */
	public String getCity(){
		return city;
	}

	/**
	 * get job's zipcode
	 * @return zipcode
	 */
	public String getZipcode(){
		return zipcode;
	}

	/**
	 * get job's school requirement
	 * @return school
	 */
	public String getSchool(){
		return school;
	}

	/**
	 * set job's state
	 * @param state
	 */
	public void setState(String state){
		this.state = state;
	}

	/**
	 * sets job's city
	 * @param city
	 */
	public void setCity(String city){
		this.city = city;
	}

	/**
	 * sets job's zipcode
	 * @param zipcode
	 */
	public void setZipcode(String zipcode){
		this.zipcode = zipcode;
	}

	/**
	 * sets job's address
	 * @param address
	 */
	public void setAddress(String address){
		this.address = address;
	}

	/**
	 * sets job's school requirement
	 * @param school
	 */
	public void setSchool(String school){
		this.school = school;
	}

	/**
	 * gets employer's database ID (reduced email)
	 * @return companyID
	 */
	public String getCompanyID(){
		return companyID;
	}

	/**
	 * sets the employer's database ID
	 * @param companyID
	 */
	public void setCompanyID(String companyID){
		this.companyID = companyID;
	}

	/**
	 * Takes arrayList and translates the elements into a String
	 * @param keywords
	 * @return String total of elements from arrayList strings
	 */
	public String arrayToString(ArrayList<String> keywords){
		String string = "";
		for(int i = 0; i < keywords.size() - 1; i ++){
			string = string + keywords.get(i) + ", ";
		}
		string = string + keywords.get(keywords.size() - 1);
		return string;
	}

	/**
	 * translates Job data into a string
	 * @return string representation of a Job
	 */
	@Override
	public String toString(){
		return jobTitle + "\n" + jobType + "\n" + address + " " + city + ", " + state + "\n" + "Salary: $" + salary + " per hour" + "\n" + "Keywords: \n" + arrayToString(keywords);
	}
}
