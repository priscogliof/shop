package com.fp.boutique.Models;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name="product")
@JsonSerialize
public class Product {
	public Product(){};
	public Product(String name, String type, String description, double cost, double quantity ) {

		this.name = name;
		this.type = type;
		this.description = description;
		this.cost = cost;
		this.quantity = quantity;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="name",nullable=false, unique=true)
	private String name;
	private String type = "";
	private String description = "";
	@Column(name="cost", nullable=false)
	private double cost = 0 ;
	private double quantity = 0 ;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long idProduit) {
		this.id = idProduit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(float prix) {
		this.cost = prix;
	}
	
	

}
