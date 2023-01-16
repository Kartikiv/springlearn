package com.database.demo.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.demo.dao.JdbcConnector;
import com.database.demo.entity.Employee;
import com.database.demo.entity.Namelist;
@Service
public class EmployeeValidation {
	Namelist namel=new Namelist();
	@Autowired
	JdbcConnector forValidation;

	public int saveEmp(Employee e) {
	return 0;}

	public int getEmp() {
		return 0;

	}
	

}
