package com.testskill.db.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Test {
	@Override
	public String toString() {
		return "Test [id=" + id + ", marks=" + marks + ", student=" + student + ", Email=" + Email + "]";
	}

	@Id
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Long marks;
	
	@ManyToOne
	private Students student;
	private String Email;

	public Test() {
		super();
	}

	

	public Test(Long id, Long marks, Students student, String email) {
		super();
		this.id = id;
		this.marks = marks;
		this.student = student;
		Email = email;
	}

	public Long getMarks() {
		return marks;
	}

	public void setMarks(Long marks) {
		this.marks = marks;
	}

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

}
