package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo1ApplicationTests {
	@Autowired
	@Qualifier("myfishobj")
	LivingThings fish;
	@Autowired
	@Qualifier("myfishobj")
	LivingThings fish1;
	@Autowired
	LivingThings someThing;

	@Autowired
	@Qualifier("al1")
	LivingThings newThing;
	@Autowired
	@Qualifier("al2")
	LivingThings newThing1;
	@Autowired
	@Qualifier("al3")
	LivingThings newThing2;
	@Autowired
	@Qualifier("al4")
	LivingThings newThing3;
	final static String FISH_GRT = "fissshhh";
	final static String HUMN_GRT = "hi";
	private String AL1_GRT = "1";
	private String AL2_GRT = "2";
	private String AL3_GRT = "3";
	private String AL4_GRT = "4";

    
    @Test
	void fishTest() {
    	 System.out.println(fish);
		assertEquals(FISH_GRT, fish.start());

	}

	@Test
	void humanTest() {
		 System.out.println( someThing);
		assertEquals(HUMN_GRT, someThing.start());
	}

	@Test
	void alienTest1() {
		 System.out.println(newThing);
		assertEquals(AL1_GRT, newThing.start());
	}

	@Test
	void alienTest2() {
		 System.out.println(newThing1);
		assertEquals(AL2_GRT, newThing1.start());
	}

	@Test
	void alienTest3() {
		 System.out.println(newThing2);
		assertEquals(AL3_GRT, newThing2.start());
	}

	@Test
	void alienTest4() {
		 System.out.println(newThing3);
		assertEquals(AL4_GRT, newThing3.start());
	}

}
