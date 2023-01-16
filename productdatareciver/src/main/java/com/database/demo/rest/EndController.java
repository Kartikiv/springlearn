package com.database.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.database.demo.pojo.product;
import com.database.demo.restcaller.Caller;
import com.database.demo.service.Validations;

@RestController
public class EndController {
	@Autowired
	Validations cal;
	@GetMapping("/caller")
	public ResponseEntity<Object> getAll() {
	      
		return cal.getAll();
		
		}
	@PostMapping("/caller")
		public ResponseEntity<Object> save(@RequestBody product p) {
			return cal.save(p);
			
		}
	@PutMapping("/caller")
		public ResponseEntity<Object> update(@RequestBody product p) {
		return	cal.update(p);
		
		}
	@GetMapping("/caller/{id}")
	    public ResponseEntity<Object> getById(@PathVariable("id") Long id) {
	    	return cal.getById(id);
	 }
	@DeleteMapping("caller/{id}")
	    public ResponseEntity<Object> delete(@PathVariable("id") long id) {
	    	return cal.delete(id);
	    }

}
