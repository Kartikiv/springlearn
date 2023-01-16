package com.example.demo;

import java.util.HashMap;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Apple implements Fruit {
	private static HashMap<String, String> APPL_NUT = new HashMap<>();
	static {
		APPL_NUT.put("Protien", "0.3G");
		APPL_NUT.put("Fat", "0.2G");
		APPL_NUT.put("Carbs", "14G");
	}

	@Override
	public String name() {

		return "Apple";
	}

	@Override
	public String color() {

		return "Bright Red";
	}

	@Override
	public double calories() {

		return 52;
	}

	@Override
	public HashMap<String, String> nutriProfile() {

		return APPL_NUT;
	}

}
