package com.student.db.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventListen {
	@Autowired
	EmailRepo repo;

	@EventListener
	public void saved(StudentRegister s) {
		repo.save(s.getS().getName() + "@test.com");
		System.out.println(s.getS() + " hi");

	}
}
