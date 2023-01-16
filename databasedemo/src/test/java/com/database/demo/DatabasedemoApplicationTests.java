package com.database.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.database.demo.enties.Students;
import com.database.demo.resoures.JdbcConnector;

@SpringBootTest
class DatabasedemoApplicationTests {
	
	@Autowired
	JdbcConnector jdbcConnector;

	@Test
	void contextLoads() {

	}

	@Test
	void showpp() {
		Students s1 = new Students(4, "ajay", "dec 2012", "9122");
		jdbcConnector.saveStud(s1);
		s1 = new Students(9, "ajay123", "dec 2012", "9122");
		jdbcConnector.saveStud(s1);
		System.out.println("The students After addition :");
		List<Students> listStudents=jdbcConnector.showstudent();
		System.out.println(listStudents);
          Students s2 = jdbcConnector.showuserById(9);
          System.out.println("The user with id 9 before update");
		System.out.println(s2);
		s2.setName("kartik");
		s2.setRollno("12-1-11");
		s2.setJoiningDate("12-12-12");
		jdbcConnector.updatestudents(s2);
		
		Students s3 = jdbcConnector.showuserById(9);
		System.out.println("After update");
		System.out.println(s3);
		System.out.println();

		System.out.println("The students after delete of user id 9");
		System.out.println(jdbcConnector.delStud(9)+"row Affected");

		System.out.println(jdbcConnector.showstudent());

	}

}
