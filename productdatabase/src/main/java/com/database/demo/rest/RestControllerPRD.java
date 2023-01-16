package com.database.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.database.demo.aspect.LoggerPrd;
import com.database.demo.dao.JpaConnector;
import com.database.demo.dao.Jpainterf;
import com.database.demo.entity.Products;
import com.database.demo.service.ServiceValidation;
import com.database.demo.service.Valadations;

@RestController
public class RestControllerPRD {
	
	@Autowired
	Valadations kar;
	
	@LoggerPrd
	@RequestMapping(value = "/saveall", method = RequestMethod.POST)
	public ResponseEntity<Object> save(@RequestBody Products p) {
		
		
	return kar.saveWithValidatinons(p);
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ResponseEntity<Object> getAll() {
		return kar.getAll();

	}

	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getById(@PathVariable("id") Long a) {
		
		return kar.getById(a);
	}
	@RequestMapping(value="/getall/{id}" ,method=RequestMethod.DELETE )
	public ResponseEntity<Object> delById(@PathVariable("id") Long a) {
		
		 return kar.delValidation(a);
	}
	@RequestMapping(value="/updatebyid/{id}/{id1}",method=RequestMethod.PUT)
	public ResponseEntity<Object> update(@PathVariable("id")String name,@PathVariable("id1")Long id) {
		
		
	
		return kar.update(name,id);
	}
}
