package com.jsware.voteAdmin.entities;

import java.sql.Date;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="vote_seq", initialValue=1)
public class Voter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="vote_seq")
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String middleName;
	
	private String streetName;
	
	private String zipcode;
	
	private String city;
	
	private String state;
	
	private String county;
	
	private Date DOB;
	
	public Voter() {
		// TODO Auto-generated constructor stub
	}

	public Voter(String[] split) {
		
		this.id = Integer.parseInt(split[0]);
		this.firstName = split[1];
		this.lastName = split[2];
		this.middleName = split[3];
		this.streetName = split[4];
		this.zipcode = split[5];
		this.city = split[6];
		this.state = split[7];
		this.county = split[8];
		this.DOB = Date.valueOf(split[9]);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

}
