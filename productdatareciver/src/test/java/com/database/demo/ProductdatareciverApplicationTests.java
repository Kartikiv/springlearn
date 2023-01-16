package com.database.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.database.demo.pojo.product;
import com.database.demo.restcaller.RestCaller;

@SpringBootTest
class ProductdatareciverApplicationTests {
	@Autowired
	RestCaller k ;
	@Test
	void contextLoads() {
		product p = new product("kavrbggve", "kvargge", "date", 1442, 1l, 15542);
	     k.update(p);
	   //  k.delete(121l);
		System.out.println(k.getAll());
	}

}
