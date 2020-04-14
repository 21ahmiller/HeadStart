package com.example.headstart;

import java.util.*;

public class User {
	
	//Data
	
	private String username;
	private String password;
	private String displayName; // preferred personal name
	private ArrayList<Job> jobs; 
	private Profile profile;
	
	//Constructors
	
	public User() {
		username = "";
		password = "";
		displayName = "";
		jobs = new ArrayList<Job>();
		profile = new Profile();
	}
	
	public User(String username, String password, String displayName) {
		this.username = username;
		this.password = password;
		this.displayName = displayName; // this is the user's personal name
		jobs = new ArrayList<Job>();
		profile = new Profile();
	}
	
	//Methods
	
	public void addJob(Job saved) {
		jobs.add(saved);
	}
	
	public void removeJob(Job saved) {
		jobs.remove(saved);
	}

	public void setDisplayName(String newName) {
		displayName = newName;
	}
	
	public String getUsername() {
		return username;
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
		
	
}
