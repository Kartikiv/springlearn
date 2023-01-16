package com.testskill.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Students {
	@Id
	private Long id;
	private String name;
	@Column(unique = true)
	private String email;
	private Long percentile;
	private Long marks;

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", email=" + email + ", percentile=" + percentile + ", marks="
				+ marks + "]";
	}

	public Students() {

	}

	public Students(Long id, String name, String email, Long percentile, Long grade) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.percentile = percentile;
		this.marks = grade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPercentile() {
		return percentile;
	}

	public void setPercentile(Long percentile) {
		this.percentile = percentile;
	}

	public Long getMarks() {
		return marks;
	}

	public void setMarks(Long grade) {
		this.marks = grade;
	}
}
