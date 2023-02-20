package org.experis2.lambdas;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Student {
	private static final DecimalFormat format = new DecimalFormat("#.##");
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private LocalDate dateOfBirth;
	
	private String cityOfBirth;
	
	private Set<String> nationalities;
	
	private int numExams;
	
	private float averageScore;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCityOfBirth() {
		return cityOfBirth;
	}

	public void setCityOfBirth(String cityOfBirth) {
		this.cityOfBirth = cityOfBirth;
	}

	public Set<String> getNationalities() {
		return nationalities;
	}

	public void setNationalities(Set<String> nationalities) {
		this.nationalities = nationalities;
	}

	public int getNumExams() {
		return numExams;
	}

	public void setNumExams(int numExams) {
		this.numExams = numExams;
	}

	public float getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(float averageScore) {
		this.averageScore = averageScore;
	}
	
	@Override
	public String toString() {
		return "[" + id + "] " + firstName + " " + lastName + " (" + dateOfBirth + ", " + cityOfBirth + "); "
				+ String.join(", ", nationalities)
				+ "; " + numExams + " esami, media " + format.format(averageScore);
	}

}
