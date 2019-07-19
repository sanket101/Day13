package com.sapient.assignment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "post_table")
@Data
public class Post implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pid")
	private long pid;
	
	private String title;
	
	private String body;
	
	public Post() {
	
	}
	
	public Post(long pid, String title, String body) {
		this.pid = pid;
		this.title = title;
		this.body = body;
	}
}
