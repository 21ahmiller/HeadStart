package com.example.headstart;

import java.util.*;

public class Profile {
	
	//Data
	
		private Location location;
		private Education education;
		private ArrayList<String> experiences;
		private ArrayList<String> interests;
		private String description;
		private String email;
		private String phoneNumber;
		private int age;
	
	//Constructors
		
		public Profile() {
			location = new Location();
			education = new Education();
			experiences = new ArrayList<String>();
			interests = new ArrayList<String>();
			description = new String();
			email = new String();
			phoneNumber = new String();
		}
		
		public Profile(Location location, Education education, String description, String email, String phoneNumber, int age) {
			this.location = location;
			this.education = education;
			experiences = new ArrayList<String>();
			interests = new ArrayList<String>();
			this.description = description;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.age = age;
		}

		//Methods
		
		public Location getLocation() {
			return location;
		}

		public void setLocation(Location location) {
			this.location = location;
		}

		public Education getEducation() {
			return education;
		}

		public void setEducation(Education education) {
			this.education = education;
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public int getAge() {
		return age;
	}

		public void setAge(int age) {
		this.age = age;
	}
}
