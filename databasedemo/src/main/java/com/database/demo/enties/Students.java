package com.database.demo.enties;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Students {
	@Id
	private int id;
	private String name;
	private String rollno;
	private String joiningDate;

	public Students() {

	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", rollno=" + rollno + ", joiningDate=" + joiningDate + "]";
	}

	public Students(int id, String name, String rollno, String joiningDate) {
		super();
		this.id = id;
		this.name = name;
		this.rollno = rollno;
		this.joiningDate = joiningDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

}
