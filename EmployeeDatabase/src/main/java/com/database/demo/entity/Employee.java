package com.database.demo.entity;

import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	Namelist namel=new Namelist();
	public Employee(int age, String name, double salary, int id) {
		super();
		this.age = age;
		namel.namelist.add(name);
		this.name = name;
		this.salary = salary;
		this.id = id;
	}

	private int age;
	private String name;
	private double salary;
	@Id
	private int id;

	public Employee() {
		
	}

	@Override
	public String toString() {
		return "Employee [age=" + age + ", name=" + name + ", salary=" + salary + ", id=" + id + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		namel.namelist.add(name);
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
