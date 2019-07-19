package com.sapient.assignment.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "user_table")
@JsonIgnoreProperties(ignoreUnknown = true)

public class User implements Serializable{
	
	@XmlElement
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    @Column(name="uid")
	private long uid;
	
	@NotEmpty
	@XmlElement
	@Column(name="name")
	private String name;
	
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	Address address;
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="uid")
	List<Post> postList;
	
	public User() {
		
	}
	
	public User(long uid, String name, Address address, List<Post> pl) {
		this.uid = uid;
		this.name = name;
		this.address = address;
		this.postList = pl;
	}
	
	public long getId() {
		return uid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

}
