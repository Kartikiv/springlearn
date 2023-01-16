package com.testskill.db.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testskill.db.aspect.Loggerstu;
import com.testskill.db.dao.JDBCConnectorStudents;
import com.testskill.db.dao.TestJDBCConnector;
import com.testskill.db.entity.Students;
import com.testskill.db.entity.Test;

@RestController
public class Controller {
	@Autowired
	JDBCConnectorStudents repo;
	@Autowired
	TestJDBCConnector repo1;
	@Loggerstu
	@GetMapping("/stu")
public Test get(@RequestBody Test s) {
		Students s1=new Students();
		s1.setId(1l);
		s1.setEmail("kartik@gmail.com");
		s1.setName("kartik");
		s1.setPercentile(10l);
		s1.setMarks(1l);
		repo.save(s1);
		 s1=new Students();
		s1.setId(2l);
		s1.setEmail("kartik1@gmail.com");
		s1.setName("kartik1");
		s1.setPercentile(10l);
		s1.setMarks(1l);
		s1.setEmail("test");
		repo.save(s1);
	
		System.out.println(repo.getAll());
		System.out.println(repo.getByID(1l)+"is with id 1");
		repo1.save(s);
		System.out.println(repo1.getAll());
		return s;
}
}
