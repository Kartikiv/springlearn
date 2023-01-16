package com.example.demo;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("orange")
public class Orange implements Fruit {
	private static HashMap<String, String> ORG_NUT = new HashMap<>();
	static {
		ORG_NUT.put("Protien", "0.9G");
		ORG_NUT.put("Fat", "0.1G");
		ORG_NUT.put("Carbs", "12G");
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Orange";
	}

	@Override
	public String color() {
		// TODO Auto-generated method stub
		return "Orange";
	}

	@Override
	public double calories() {
		// TODO Auto-generated method stub
		return 47;
	}

	@Override
	public HashMap<String, String> nutriProfile() {
		// TODO Auto-generated method stub
		return ORG_NUT;
	}

}
