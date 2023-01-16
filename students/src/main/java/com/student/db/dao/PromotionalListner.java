package com.student.db.dao;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
@Component
public class PromotionalListner {
	
	@EventListener
	@Async
	public void promoCreated(StudentRegister event) {
		
		System.out.println("promotion for " + event.getS().getName());
	}
}
