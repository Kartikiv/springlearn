package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoApplicationTests {
	
	
	@Autowired(required=false)
	Fruit f1;
	@Autowired 
	@Qualifier("banana")
	Fruit f2;
	@Autowired
	@Qualifier("alph")
	Fruit f3;
	@Autowired
	@Qualifier("Amrp")
	Fruit f4;
	@Autowired
	@Qualifier("Atlf")
	Fruit f5;
	@Autowired
	@Qualifier("orange")
	Fruit f6;
	@Autowired
	@Qualifier("Irw")
	Fruit f7;
	@Autowired
	VerificatioN v;
	HashMap<Integer, Fruit> map = new HashMap<>();
	
   
	 public  void insert() { map.put(1, f1);map.put(2, f2);map.put(3, f3);map.put(4, f4);map.put(5, f5);map.put(6, f6);map.put(7, f7);
	  
	 }
	
	
		

	@Test
	void contextLoads() {
		insert();
		for (int i = 1; i < 8; i++) {
			System.out.println(map.get(i));
		}
	}
	@Test
	void nameTest() {
		insert();
		for (int i = 1; i < 8; i++) {
			assertEquals(map.get(i).name(),v.name(i)); 
			System.out.println(map.get(i).name());
		}
	}
	@Test
	void colorTest() {
		insert();
		for (int i = 1; i < 8; i++) {
			assertEquals(map.get(i).color(),v.color(i)); 
			System.out.println(map.get(i).color());
		}
	}
	@Test
	void calTest() {
		insert();
		for (int i = 1; i < 8; i++) {
			assertEquals(map.get(i).calories(),v.cal(i)); 
			System.out.println(map.get(i).calories());
		}
	}
	@Test
	void nutTest() {
		insert();
		for (int i = 1; i < 8; i++) {
			assertEquals(map.get(i).nutriProfile(),v.nut(i)); 
			System.out.println(map.get(i).nutriProfile());
		}
	}

	
	@Test
	void appleTest() {
		assertEquals(f1.name(),v.name(1) );
		assertEquals(f1.calories(),v.cal(1) );
		assertEquals(f1.color(),v.color(1) );
		assertEquals(f1.nutriProfile(),v.nut(1) );
		System.out.println(f1.name()+" "+f1.calories()+" "+f1.color());
		System.out.println(f1.nutriProfile());
		
	}
	@Test
	void bananaTest() {
		assertEquals(f2.name(),v.name(2) );
		assertEquals(f2.calories(),v.cal(2) );
		assertEquals(f2.color(),v.color(2) );
		assertEquals(f2.nutriProfile(),v.nut(2) );
		System.out.println(f2.name()+" "+f2.calories()+" "+f2.color());
		System.out.println(f2.nutriProfile());
		
	}
	@Test
	void alphTest() {
		assertEquals(f3.name(),v.name(3) );
		assertEquals(f3.calories(),v.cal(3) );
		assertEquals(f3.color(),v.color(3) );
		assertEquals(f3.nutriProfile(),v.nut(3) );
		System.out.println(f3.name()+" "+f3.calories()+" "+f3.color());
		System.out.println(f3.nutriProfile());
		
	}
	@Test
	void amrpTest() {
		assertEquals(f4.name(),v.name(4) );
		assertEquals(f4.calories(),v.cal(4) );
		assertEquals(f4.color(),v.color(4) );
		assertEquals(f4.nutriProfile(),v.nut(4) );
		System.out.println(f4.name()+" "+f4.calories()+" "+f4.color());
		System.out.println(f4.nutriProfile());
		
	}
	@Test
	void atauTest() {
		assertEquals(f5.name(),v.name(5) );
		assertEquals(f5.calories(),v.cal(5) );
		assertEquals(f5.color(),v.color(5) );
		assertEquals(f5.nutriProfile(),v.nut(5) );
		System.out.println(f5.name()+" "+f5.calories()+" "+f5.color());
		System.out.println(f5.nutriProfile());
		
	}
	@Test
	void orgTest() {
		assertEquals(f6.name(),v.name(6) );
		assertEquals(f6.calories(),v.cal(6) );
		assertEquals(f6.color(),v.color(6) );
		assertEquals(f6.nutriProfile(),v.nut(6) );
		System.out.println(f6.name()+" "+f6.calories()+" "+f6.color());
		System.out.println(f6.nutriProfile());
		
	}

	@Test
	void iriwTest() {
		assertEquals(f7.name(),v.name(7) );
		assertEquals(f7.calories(),v.cal(7) );
		assertEquals(f7.color(),v.color(7) );
		assertEquals(f7.nutriProfile(),v.nut(7) );
		System.out.println(f7.name()+" "+f7.calories()+" "+f7.color());
		System.out.println(f7.nutriProfile());
		
	}
}
