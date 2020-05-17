package com.example.headstart;

import java.util.*;

public class Education {
	
	// Education data
	private String year;
	private String school;  //high school, college, "" for either


	/**
	 * Creates empty education
	 */
	public Education() {
		year = "";
		school = "";
	}

	/**
	 * Creates education with year and school
	 * @param year
	 * @param school
	 */
	public Education(String year, String school) {
		this.year = year;
		this.school = school;
	}

	/**
	 * Gets year of school
	 * @return year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * sets year of school to given year
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * Gets school
	 * @return school
	 */
	public String getSchool() {
		return school;
	}

	/**
	 * sets school to given school
	 * @param school
	 */
	public void setSchool(String school) {
		this.school = school;
	}

	/**
	 * translates data to a string
	 * @return string representation of education
	 */
	@Override
	public String toString() {
		if (school.equals("High School") || school.equals("College") && !year.equals("")) {
			return year + " in " + school;
		} else if (!school.equals("")) {
			return school;
		}
		return "";
	}
}
