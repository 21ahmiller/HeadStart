package com.example.headstart;

import java.util.*;

public class Profile {
	
	//Data
	
		private Location location;
		private Education education;
		private ArrayList<String> experiences;
		private ArrayList<String> interests;
		private String description;
		private String phoneNumber;
		private String age;
	
	//Constructors
		
		public Profile() {
			location = new Location();
			education = new Education();
			experiences = new ArrayList<String>();
			interests = new ArrayList<String>();
			description = new String();
			phoneNumber = new String();
			age = new String();
		}
		
		public Profile(String state, String city, String zipcode, String year, String school, String description, String phoneNumber, String age) {
			this.location = new Location(state, city, zipcode, "");
			this.education = new Education(year, school);
			experiences = new ArrayList<String>();
			interests = new ArrayList<String>();
			this.description = description;
			this.phoneNumber = phoneNumber;
			this.age = age;
		}

		public Profile(String state, String city, String zipcode, String address, String description, String phoneNumber){
			this.location = new Location(state, city, zipcode, address);
			this.description = description;
			this.phoneNumber = phoneNumber;
			education = new Education();
			experiences = new ArrayList<String>();
			interests = new ArrayList<String>();
			age = new String();
		}

		//Methods
		
		public Location getLocation() {
			return location;
		}

		public void setLocation(String state, String city, String zipcode, String address) {
			this.location = new Location(state, city, zipcode, address);
		}

		public Education getEducation() {
			return education;
		}

		public void setEducation(String year, String school) {
			this.education = new Education(year, school);
		}

		public ArrayList<String> getExperiences() {
			return experiences;
		}
		
		public void addExperience(String added) {
			experiences.add(added);
		}
		
		public void removeExperience(String removed) {
			experiences.remove(removed);
		}

		public ArrayList<String> getInterests() {
			return interests;
		}
		
		public void addInterest(String added) {
			interests.add(added);
		}
		
		public void removeInterest(String removed) {
			interests.remove(removed);
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getAge() {
		return age;
	}

		public void setAge(String age) {
		this.age = age;
	}
}
