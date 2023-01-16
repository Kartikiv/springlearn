package com.student.db.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Students {
	@Id
	private Long id;
	
	private Date date;
	private String name;
	private Short marks;
	private Short percentile;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Short getMarks() {
		return marks;
	}
	public void setMarks(Short marks) {
		this.marks = marks;
	}
	public Short getPercentile() {
		return percentile;
	}
	public void setPercentile(Short percentile) {
		this.percentile = percentile;
	}

}
