package com.database.demo;

import org.springframework.beans.factory.annotation.Autowired;import com.database.demo.enties.Students;
import com.database.demo.resoures.JdbcConnector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.database.demo.enties.Students;
import com.database.demo.resoures.JdbcConnector;

@SpringBootApplication
public class DatabasedemoApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(DatabasedemoApplication.class, args);
		
	}

}
