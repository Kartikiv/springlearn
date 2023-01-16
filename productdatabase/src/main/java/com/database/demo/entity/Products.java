package com.database.demo.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	private String name;

	private BigDecimal price;

	@CreationTimestamp
	private Date createddate;

	public Products() {
		
	}

	public Products(Long id, String description, String name, BigDecimal price, Date createddate, Date updateddate) {
		super();
		this.id = id;
		this.description = description;
		this.name = name;
		this.price = price;
		this.createddate = createddate;
		this.updateddate = updateddate;
	}

	@UpdateTimestamp
	private Date updateddate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", description=" + description + ", name=" + name + ", price=" + price
				+ ", createddate=" + createddate + ", updateddate=" + updateddate + "]";
	}

}
