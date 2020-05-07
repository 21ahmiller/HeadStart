package com.example.headstart;

import java.util.*;

public class Employer extends User{
	
	//Constructors
	
	public Employer() {
		super();
	}

	public Employer(String username, String password, String displayName) {
		super(username, password, displayName);
	}

	//Methods
	
	@Override
	public void addJob(Job saved) {
		super.addJob(saved);
		this.uploadCloudJob(saved);
	}
	
	@Override
	public void removeJob(Job saved) {
		super.removeJob(saved);
		this.deleteCloudJob(saved);
	}
	
	public void uploadCloudJob(Job job) {
		//fill in
	}
	
	public void  deleteCloudJob(Job job) {
		//fill in
	}

	public String toString() {
		return super.toString();
	}
}
