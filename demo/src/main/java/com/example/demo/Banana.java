package com.example.demo;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("banana")
public class Banana implements Fruit {
	private static HashMap<String, String> BNA_NUT = new HashMap<>();
	 public static void put(){
		BNA_NUT.put("Protien", "1.1G");
		BNA_NUT.put("Fat", "0.3G");
		BNA_NUT.put("Carbs", "23G");
	}
	 

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Banana";
	}

	@Override
	public String color() {
		// TODO Auto-generated method stub
		return "Yellow";
	}

	@Override
	public double calories() {
		// TODO Auto-generated method stub
		return 89;
	}

	@Override
	public HashMap<String, String> nutriProfile() {
		// TODO Auto-generated method stub
		Banana.put();
		return BNA_NUT;
	}

}
