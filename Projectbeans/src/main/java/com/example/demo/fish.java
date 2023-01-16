package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("myfishobj")
public class fish implements LivingThings  {

	//@Override
	public String start() {
		// TODO Auto-generated method stub
		return "fissshhh";

	}

}
