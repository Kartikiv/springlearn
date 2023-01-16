package com.testskill.db;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.testskill.db.dao.JDBCConnectorStudents;
import com.testskill.db.dao.TestJDBCConnector;
import com.testskill.db.entity.Students;

@SpringBootTest
class TestskillsApplicationTests {
@Autowired
JDBCConnectorStudents repo;
@Autowired
TestJDBCConnector repo1;
	@Test
	void contextLoads() {
		Students s=new Students();
		s.setId(1l);
		s.setEmail("kartik@gmail.com");
		s.setName("kartik");
		s.setPercentile(10l);
		s.setMarks(1l);
		repo.save(s);
		s.setEmail("test");
		repo.update(s);
		repo1.save(s);
		System.out.println(repo.getAll());
		System.out.println(repo.getByID(1l)+"is with id 1");
	}

}
