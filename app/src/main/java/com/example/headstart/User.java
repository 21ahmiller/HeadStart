package com.example.headstart;

import com.google.firebase.database.DatabaseReference;

import java.util.*;

public class User {
	
	//Data

	/**
	 * The email of the user
	 */
	private String email;

	/**
	 * the password of the user
	 */
	private String password;

	/**
	 * The display name of the user
	 */
	private String displayName;

	/**
	 * The jobs that a user has
	 */
	private ArrayList<Job> jobs;

	/**
	 * The proile of the user
	 */
	private Profile profile;
	
	//Constructors

	/**
	 * Creates a blank user object
	 */
	public User() {
		email = "";
		password = "";
		displayName = "";
		jobs = new ArrayList<Job>();
		profile = new Profile();
	}

	/**
	 * Creates a user with an email, password, and display name
	 * @param email the email
	 * @param password the password
	 * @param displayName the displayed name
	 */
	public User(String email, String password, String displayName) {
		this.email = email;
		this.password = password;
		this.displayName = displayName; // this is the user's personal name
		jobs = new ArrayList<Job>();
		profile = new Profile();
	}
	
	//Methods

	/**
	 * Adds a job to the jobs arraylist
	 * @param saved the job being added
	 */
	public void addJob(Job saved) {
		jobs.add(saved);
	}

	/**
	 * Removes a job from the jobs list
	 * @param position the position of the job
	 */
	public void removeJob(int position) {
		jobs.remove(position);
	}

	/**
	 * Sets the display name of a user
	 * @param newName the new display name
	 */
	public void setDisplayName(String newName) {
		displayName = newName;
	}

	/**
	 * Sets the email of a user
	 * @param newEmail the new email
	 */
	public void setEmail(String newEmail) {
		email = newEmail;
	}

	/**
	 * Gets the email of a user
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Gets the display name of a user
	 * @return the display name
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Gets the profile of a user
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}

	/**
	 * Sets the profile of a user
	 * @param profile the new profile
	 */
	public void setProfile(Profile profile){
		this.profile = profile;
	}

	/**
	 * Returns the ArrayList of jobs that the user has
	 * @return the jobs
	 */
	public ArrayList<Job> getJobs(){
		return jobs;
	}

	/**
	 * Gets the password of a user
	 * @return the password
	 */
	public String getPassword(){
		return password;
	}

	/**
	 * Checks to see if the password being checked is the same as the user's password
	 * @param inputPassword the input password
	 * @return a boolean indicating whether or not the password matches
	 */
	public boolean comparePassword(String inputPassword){
		if(password.equals(inputPassword)){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * The override to the toString method
	 * @return returns the user as a string
	 */
	@Override
	public String toString() {
		return "User{" +
				"email='" + email + '\'' +
				", password='" + password + '\'' +
				", displayName='" + displayName + '\'' +
				", jobs=" + jobs +
				", profile=" + profile.toString() +
				'}';
	}
}
