package com.database.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.database.demo.Beans.Products;
import com.database.demo.Service.SeriveValidation;

@RestController
public class RestControlProducts {
	@Autowired
	SeriveValidation service;

	@PostMapping("/in")
	public int insertPrd(@RequestBody Products p) {
		return service.insertPrd(p);
	}
	
	@PostMapping("/up")
	public int updPrd(@RequestBody Products p) {
		return service.updatePrd(p);
	}
	@PostMapping("/del")
	public Object delPrd(@RequestBody Products p) {
		return service.delete(p);
	}
	@PostMapping("/get")
	public Object getall() {
		  return service.getall();
}
}
