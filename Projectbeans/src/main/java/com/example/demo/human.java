package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class human  implements LivingThings {

	@Override
	public String start() {
		// TODO Auto-generated method stub
		return"hi";
		
	}

	
		
	

}
