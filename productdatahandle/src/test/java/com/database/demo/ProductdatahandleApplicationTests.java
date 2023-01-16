package com.database.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.database.demo.dao.Connector;
import com.database.demo.entity.Products;

@SpringBootTest
class ProductdatahandleApplicationTests {
	@Autowired
	Connector con;
	@Test
	void contextLoads() {
		Products p =new Products();
		p.setId(1l);
		p.setName("product");
		p.setStockInInventory(0);
		p.setSeller("seller");
		p.setPrice(114);
		p.setCreatedDate("null");
	con.save(p);
	p.setName("karr");
	con.updateByID(p);
	System.out.println(con.getById(1l));
System.out.println(	con.getAll());
con.deleteById(1l);
System.out.println(	con.getAll());
	
	}

}
