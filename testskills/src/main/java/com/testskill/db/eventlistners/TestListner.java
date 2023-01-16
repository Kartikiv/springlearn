package com.testskill.db.eventlistners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.testskill.db.dao.JDBCConnectorStudents;
import com.testskill.db.entity.Students;
import com.testskill.db.events.TestTakenEvent;

@Component
public class TestListner {
	@Autowired
	JDBCConnectorStudents repo;
@EventListener
public void listnnerTest(TestTakenEvent event) {
	long custId=event.getTest().getId();
	Students s=repo.getByID(custId);
	System.out.println(s+" "+event.getTest().getMarks());
	s.setMarks(event.getTest().getMarks());
	repo.update(s);
}
}
