package com.database.demo.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.database.demo.entity.Products;
import com.database.demo.service.Validations;

@RestController
public class EndPointController {

	@Autowired
	Validations request;

	@PostMapping("/products")
	public ResponseEntity<Object> saveprd(@RequestBody Products p) {
		return request.saveprd(p);

	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable("id") Long l) {
		return request.delById(l);
	}

	@GetMapping("/products")
	public ResponseEntity<Object> getAll() {
		return request.getAll();
	}

	@PutMapping("/products/update")
	public ResponseEntity<Object> updateByID(@RequestBody Products p) {
		return request.updateprd(p);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Object> getById(@PathVariable("id") Long l) {
		return request.getById(l);

	}

	@GetMapping("/linc")
	public String textLinc(HttpServletResponse response) {
		response.setHeader("Content-Disposition", "attachment; filename=license.txt");
		File File = new File("C:\\Users\\karth\\Downloads\\license.txt");

		try {
			BufferedReader br = new BufferedReader(new FileReader(File));
			String st = "";
			String text = "";
			while ((st = br.readLine()) != null) {
				text = text + st;

			}
			return text;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}