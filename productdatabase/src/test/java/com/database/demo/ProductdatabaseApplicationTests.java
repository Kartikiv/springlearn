package com.database.demo;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.database.demo.entity.Products;
import com.database.demo.service.Valadations;

@SpringBootTest
class ProductdatabaseApplicationTests {
	@Autowired
	Valadations kar;
	@Test
	void testAddMethod() {
		Products p=new Products(null,"prd","kar",new BigDecimal(12),null,null);
		kar.saveWithValidatinons(p);
		System.out.println(kar.getAll());
		Products p1=new Products(null,"prd","kar",new BigDecimal(12),null,null);
		kar.saveWithValidatinons(p1);
		p1.setName("kariv");
		kar.saveWithValidatinons(p1);
		System.out.println(kar.getAll());
		Products p2=new Products(null,"prd","   ",new BigDecimal(12),null,null);
		kar.saveWithValidatinons(p2);
		System.out.println(kar.getAll());
		Products p3=new Products(null,"prd"," negprice  ",new BigDecimal(-1),null,null);
		kar.saveWithValidatinons(p3);
		Products p4=new Products(null,"prd"," postivepricegreater  ",new BigDecimal(100000),null,null);
		kar.saveWithValidatinons(p4);
		System.out.println(kar.getAll());
	}
	@Test
	void testDelmethod() {
		kar.delValidation(1l);
		kar.delValidation(12l);
		System.out.println(kar.getAll());
	}
	@Test
	void testGetById() {
		kar.getById(1L);
	}
	@Test
	void testGetAll() {
		System.out.println(kar.getAll());
		
	}
	@Test 
	void testUpdate() {
		Products p1=new Products(2l,"prd","kar",new BigDecimal(12),null,null);
		kar.update("kar",2l);
		System.out.println(kar.getAll()+" test done!---------->");
	}
	
	

}
