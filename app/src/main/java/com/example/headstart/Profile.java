package com.example.headstart;

import java.util.*;

public class Profile {
	
	//Data
	/**
	 * The location of the user; used for tracking distance between jobs
	 */
		private Location location;

	/**
	 * the education of the user; also used in the filter method
	 */
		private Education education;

	/**
	 * the experiences that the user had; a nice to have that users could use to apply to jobs through the app
	 */
		private ArrayList<String> experiences;

	/**
	 * The interests of the user; a nice to have that users could use to apply to jobs through the app
	 */
		private ArrayList<String> interests;

	/**
	 * The description used for a user or company about themselves
	 */
		private String description;

	/**
	 * The phone number of the user or employer
	 */
		private String phoneNumber;

	/**
	 * The age of the user; used for filter purposes
	 */
		private String age;
	
	//Constructors

	/**
	 * Makes a new blank profile
	 */
		public Profile() {
			location = new Location();
			education = new Education();
			experiences = new ArrayList<String>();
			interests = new ArrayList<String>();
			description = new String();
			phoneNumber = new String();
			age = new String();
		}

	/**
	 *Creates a profile object with filled out data and a blank address
	 * @param state the state
	 * @param city the city
	 * @param zipcode the zipcode
	 * @param year the year
	 * @param school the school
	 * @param description the description
	 * @param phoneNumber the phoneNumber
	 * @param age the age
	 */
		public Profile(String state, String city, String zipcode, String year, String school, String description, String phoneNumber, String age) {
			this.location = new Location(state, city, zipcode, "");
			this.education = new Education(year, school);
			experiences = new ArrayList<String>();
			interests = new ArrayList<String>();
			this.description = description;
			this.phoneNumber = phoneNumber;
			this.age = age;
		}

	/**
	 * Creates a profile with fully filled out data
	 * @param state state
	 * @param city city
	 * @param zipcode zipcode
	 * @param address address
	 * @param description description
	 * @param phoneNumber phone number
	 */
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

	/**
	 * gets the location from the profile
	 * @return the location
	 */
		public Location getLocation() {
			return location;
		}

	/**
	 * Sets the location of a profile
	 * @param state state
	 * @param city city
	 * @param zipcode zipcode
	 * @param address address
	 */
		public void setLocation(String state, String city, String zipcode, String address) {
			this.location = new Location(state, city, zipcode, address);
		}

	/**
	 * returns the education that a user has
	 * @return the education
	 */
		public Education getEducation() {
			return education;
		}

	/**
	 * Sets the education for the profile
	 * @param year the year of enrollment (freshman, sophomore, etc.)
	 * @param school the school being attended(high school, college, etc.)
	 */
		public void setEducation(String year, String school) {
			this.education = new Education(year, school);
		}

	/**
	 * Gets the experiences a user has
	 * @return the list of experiences
	 */
		public ArrayList<String> getExperiences() {
			return experiences;
		}

	/**
	 * Gets the interests that a user has
	 * @return the list of interests
	 */
		public ArrayList<String> getInterests() {
			return interests;
		}

	/**
	 * Gets the user or employer description
	 * @return the description
	 */
		public String getDescription() {
			return description;
		}

	/**
	 * sets the description of a user or employer
	 * @param description the description
	 */
		public void setDescription(String description) {
			this.description = description;
		}

	/**
	 * Gets the user or employer's phone number
	 * @return the phone number
	 */
		public String getPhoneNumber() {
			return phoneNumber;
		}

	/**
	 * Sets the phone number for a user or employer
	 * @param phoneNumber the phone number
	 */
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

	/**
	 * Gets the age of a user; used for filtering purposes
	 * @return the age
	 */
		public String getAge() {
		return age;
	}

	/**
	 * Sets the age for a user
	 * @param age the age of the user
	 */
		public void setAge(String age) {
		this.age = age;
	}

	/**
	 * An override of the toString method; Displays all the different aspects of the profile.
	 * @return
	 */
	@Override
	public String toString() {
		return "Profile{" +
				"location=" + location +
				", education=" + education +
				", experiences=" + experiences +
				", interests=" + interests +
				", description='" + description + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", age='" + age + '\'' +
				'}';
	}
}
