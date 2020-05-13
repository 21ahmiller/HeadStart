package com.example.headstart;

import com.google.firebase.database.DatabaseReference;

import java.util.*;

public class User {
	
	//Data
	
	private String email;
	private String password;
	private String displayName; // preferred personal name
	private ArrayList<Job> jobs; 
	private Profile profile;
	
	//Constructors
	
	public User() {
		email = "";
		password = "";
		displayName = "";
		jobs = new ArrayList<Job>();
		profile = new Profile();
	}
	
	public User(String email, String password, String displayName) {
		this.email = email;
		this.password = password;
		this.displayName = displayName; // this is the user's personal name
		jobs = new ArrayList<Job>();
		profile = new Profile();
	}
	
	//Methods
	
	public void addJob(Job saved) {
		jobs.add(saved);
	}
	
	public void removeJob(int position) {
		jobs.remove(position);
	}

	public void setDisplayName(String newName) {
		displayName = newName;
	}

	public void setEmail(String newEmail) {
		email = newEmail;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile){
		this.profile = profile;
	}

	public ArrayList<Job> getJobs(){
		return jobs;
	}

	public String getPassword(){
		return password;
	}

	//DELETE


	public boolean comparePassword(String inputPassword){
		if(password.equals(inputPassword)){
			return true;
		}
		else{
			return false;
		}
	}

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
