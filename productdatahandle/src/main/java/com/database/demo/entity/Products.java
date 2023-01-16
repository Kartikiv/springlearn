package com.database.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;


@Entity

public class Products {

	@Column(unique = true)
	private String name;
	public Products(String name, String seller, String createdDate, double price, Long id, int stockInInventory) {
		super();
		this.name = name;
		this.seller = seller;
		this.createdDate = createdDate;
		this.price = price;
		this.id = id;
		this.stockInInventory = stockInInventory;
	}

	private String seller;
	@CreatedDate
	private String createdDate;

	private double price;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int stockInInventory;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	@Override
	public String toString() {
		return "Products [name=" + name + ", seller=" + seller + ", createdDate=" + createdDate + ", price=" + price
				+ ", id=" + id + ", stockInInventory=" + stockInInventory + "]";
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Products() {
		super();
	}

	
	public int getStockInInventory() {
		return stockInInventory;
	}

	public void setStockInInventory(int stockInInventory) {
		this.stockInInventory = stockInInventory;
	}

}
