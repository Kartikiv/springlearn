package com.database.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.database.demo.enties.Students;
import com.database.demo.resoures.JdbcConnector;
@Component
public class EmpAdd {
@Autowired
JdbcConnector kar;
public void add() {
	Students s1=new Students(9,"ajay","dec 2012","9122");
	kar.saveStud(s1);
}
}
