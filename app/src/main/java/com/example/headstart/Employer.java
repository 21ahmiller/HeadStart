package com.example.headstart;

import java.util.*;

public class Employer extends User{

	//Data for Employer
	private String companyDescription;
	private String companyBackground;

	/**
	 * Creates empty employer
	 */
	public Employer() {
		super();
		companyBackground = "";
		companyDescription = "";
	}

	/**
	 * Creates employer with username, password and display name
	 * @param username
	 * @param password
	 * @param displayName
	 */
	public Employer(String username, String password, String displayName) {
		super(username, password, displayName);
		companyDescription = "";
		companyBackground = "";
	}

	/**
	 * adds a job to arrayList jobs in User class
	 * @param saved
	 */
	@Override
	public void addJob(Job saved) {
		super.addJob(saved);
	}

	/**
	 * removes a job from arrayList jobs in User class
	 * @param position
	 */
	@Override
	public void removeJob(int position) {
		super.removeJob(position);
	}

	/**
	 * gets description of employer
	 * @return companyDescription
	 */
	public String getCompanyDescription(){
		return companyDescription;
	}

	/**
	 * gets background of employer
	 * @return companyBackground
	 */
	public String getCompanyBackground(){
		return companyBackground;
	}

	/**
	 * sets description of employer
	 * @param companyDescription
	 */
	public void setCompanyDescription(String companyDescription){
		this.companyDescription = companyDescription;
	}

	/**
	 * sets background of employer
	 * @param companyBackground
	 */
	public void setCompanyBackground(String companyBackground){
		this.companyBackground = companyBackground;
	}

	/**
	 * calls super toString method to output User data
	 * @return string representation of employer (as user)
	 */
	public String toString() {
		return super.toString();
	}

	/**
	 * updates employer's arraylist of jobs in Firebase
	 */
	public void updateFireBaseJobs(){
		Database employers = new Database("Employers");
		String ID = emailReducer(super.getEmail());
		employers.getDatabaseReference().child(ID).child("jobs").setValue(super.getJobs());
	}

	/**
	 * changes email into unique ID without unallowed characters
	 * @param email
	 * @return reduced
	 */
	public String emailReducer(String email){
		ArrayList<String> characters = new ArrayList<String>();
		for(int i = 0; i < email.length(); i ++){
			characters.add(email.substring(i, i + 1));
		}
		characters.remove("@");
		characters.remove(".");
		String reduced = "";
		for(int i = 0; i < characters.size(); i++){
			reduced += characters.get(i);
		}
		return reduced;
	}
}
