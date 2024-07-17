package com.fp.boutique.Models;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name="products")
@JsonSerialize
public class Product {
	public Product(){};
	
	public Product(String code, String name, String description, Double price, Integer quantity, String inventoryStatus,
			String category, String image, Double rating) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.inventoryStatus = inventoryStatus;
		this.category = category;
		this.image = image;
		this.rating = rating;
	}

	public Product(String name, String description, double price, Integer quantity ) {

		this.name = name;
		
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;


	@Column(unique = true)

	  private String code;

	  

	  private String name;

	  

	  private String description;

	  

	  private Double price;

	  

	  private Integer quantity;

	  
	  @Column(name = "inventory_status")
	  private String inventoryStatus;

	  

	  private String category;

	  

	  private String image;

	  

	  private Double rating;
	
	
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

	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	  

	  public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getInventoryStatus() {
		return inventoryStatus;
	}
	public void setInventoryStatus(String inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
	return quantity;
	}
	public void setQuantity(Integer d) {
	this.quantity = d;
	}
}