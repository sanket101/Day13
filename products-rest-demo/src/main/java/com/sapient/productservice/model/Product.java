package com.sapient.productservice.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "product_table")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Product implements Serializable{
	
	@XmlElement
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
	private long id;
	
	@NotEmpty
	@XmlElement
	@Column
	private String name;
	
	@NotNull
	@XmlElement
	@Column
	private double price;
	
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private ProductDetails productDetails;
	 
	public Product() {
		
	}
	
	public Product(long id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
}
