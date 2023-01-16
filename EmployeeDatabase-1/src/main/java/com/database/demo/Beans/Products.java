package com.database.demo.Beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Products {
	private String name;
	private String desp;
	@Id
	private Long id;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesp() {
		return desp;
	}
	public void setDesp(String desp) {
		this.desp = desp;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Products [name=" + name + ", desp=" + desp + ", id=" + id + "]";
	}
	
	

}
