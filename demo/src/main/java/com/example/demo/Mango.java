package com.example.demo;

import java.util.HashMap;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class Mango implements Fruit {
	private final int x;
	static HashMap<Integer,String> mName = new HashMap<Integer,String>() {{
	put(1, "Alphnso");
	put(2, "Amrapali");
	put(3, "Ataulfo");
	put(4, "Iriwin");
	}};

	public Mango(int x) {
     this.x=x;
	}

	private static HashMap<String, String> MANG_NUT = new HashMap<>();
	static {
		MANG_NUT.put("Protien", "0.8G");
		MANG_NUT.put("Fat", "0.4G");
		MANG_NUT.put("Carbs", "15G");
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return mName.get(x);
	}

	@Override
	public String color() {
		if(x==2) {
			return "Green";
		}
		if(x==4) {
			return "Red";
		}
		// TODO Auto-generated method stub
		return "Yellow";
	}

	@Override
	public double calories() {
		// TODO Auto-generated method stub
		return 60;
	}

	@Override
	public HashMap<String, String> nutriProfile() {
		// TODO Auto-generated method stub
		return MANG_NUT;
	}

}