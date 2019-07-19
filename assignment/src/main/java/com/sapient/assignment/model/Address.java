package com.sapient.assignment.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "address_table")

public class Address implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long aid;
	
	private String city;
	private String state;
	private String country;
	private long zipcode;
	
	public Address() {
		
	}
	
	public Address(long aid, String city, String state, String country, long zipcode) {
		this.aid = aid;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}
	
}
