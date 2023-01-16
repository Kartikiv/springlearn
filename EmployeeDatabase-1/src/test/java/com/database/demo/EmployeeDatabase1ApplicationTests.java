package com.database.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class EmployeeDatabase1ApplicationTests {

	@Test
	void contextLoads() {
		RestTemplate template=new RestTemplate();
		List s=template.getForObject("https://jsonplaceholder.typicode.com/posts", List.class);
		System.out.println(s);
	}

}
