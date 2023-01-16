package com.example.demo;

import java.util.HashMap;

import org.springframework.stereotype.Component;
@Component
public class VldF implements VerificatioN {
	private static HashMap<String, String> APPL_NUT = new HashMap<>();
	static {
		APPL_NUT.put("Protien", "0.3G");
		APPL_NUT.put("Fat", "0.2G");
		APPL_NUT.put("Carbs", "14G");
	}
	private static HashMap<String, String> BNA_NUT = new HashMap<>();
	 static {
		BNA_NUT.put("Protien", "1.1G");
		BNA_NUT.put("Fat", "0.3G");
		BNA_NUT.put("Carbs", "23G");
	}
	 private static HashMap<String, String> ORG_NUT = new HashMap<>();
		static {
			ORG_NUT.put("Protien", "0.9G");
			ORG_NUT.put("Fat", "0.1G");
			ORG_NUT.put("Carbs", "12G");
		}
		private static HashMap<String, String> MANG_NUT = new HashMap<>();
		static {
			MANG_NUT.put("Protien", "0.8G");
			MANG_NUT.put("Fat", "0.4G");
			MANG_NUT.put("Carbs", "15G");
		}
	static HashMap<Integer, String> name = new HashMap<>() {
		{
			put(1, "Apple");
			put(2, "Banana");
			put(3, "Alphnso");
			put(4, "Amrapali");
			put(5, "Ataulfo");
			put(6, "Orange");
			put(7, "Iriwin");
		}
	};
	static HashMap<Integer, Double> cal = new HashMap<>() {
		{
			put(1, (double) 52);
			put(2, (double) 89);
			put(3, (double) 60);
			put(4, (double) 60);
			put(5, (double) 60);
			put(6, (double) 47);
			put(7, (double) 60);

		}
	};
	static HashMap<Integer, String> color = new HashMap<>() {
		{
			put(1, "Bright Red"); 
			put(2,"Yellow");
			put(3,"Yellow");
			put(4,"Green");
			put(5,"Yellow");
			put(6,"Orange");
			put(7,"Red");
		}
	};

	static HashMap<Integer, HashMap<String, String>> nut = new HashMap<>() {{
	put(1,APPL_NUT);
	put(2,BNA_NUT);
	put(3,MANG_NUT);
	put(4,MANG_NUT);
	put(5,MANG_NUT);
	put(6,ORG_NUT);
	put(7,MANG_NUT);

	
	}
	};

	public String name(int i) {
		return name.get(i);
	}

	public double cal(int i) {
		return cal.get(i);
	}
	public String color(int i) {
		return color.get(i);
	}
public 	HashMap<String, String> nut(int i){
	return nut.get(i);
}

}
