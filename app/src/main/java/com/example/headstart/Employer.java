package com.example.headstart;

import java.util.*;

public class Employer extends User{

	//Data

	private String companyDescription;
	private String companyBackground;

	//Constructors

	public Employer() {
		super();
		companyBackground = "";
		companyDescription = "";
	}

	public Employer(String username, String password, String displayName) {
		super(username, password, displayName);
		companyDescription = "";
		companyBackground = "";
	}

	//Methods
	
	@Override
	public void addJob(Job saved) {
		super.addJob(saved);
		this.uploadCloudJob(saved);
	}
	
	@Override
	public void removeJob(int position) {
		super.removeJob(position);
		// delete job from the cloud
	}

	public String getCompanyDescription(){
		return companyDescription;
	}

	public String getCompanyBackground(){
		return companyBackground;
	}

	public void setCompanyDescription(String companyDescription){
		this.companyDescription = companyDescription;
	}

	public void setCompanyBackground(String companyBackground){
		this.companyBackground = companyBackground;
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
