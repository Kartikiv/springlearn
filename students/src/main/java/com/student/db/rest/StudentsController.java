package com.student.db.rest;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.student.db.entity.Students;
import com.student.db.service.StudentsService;

@RestController
@RequestMapping("/students")
public class StudentsController {
	@Autowired
	StudentsService repo;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody Students s) {
		Students saved = repo.save(s);
		if (saved == null) {
			return new ResponseEntity<Object>("INVALID", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(saved, HttpStatus.ACCEPTED);
	}

	@PostMapping("/upd")
	public ResponseEntity<Object> update(@RequestBody Students s) {
		Students saved = repo.update(s);

		if (saved == null) {
			return new ResponseEntity<Object>("INVALID", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(saved, HttpStatus.ACCEPTED);

	}

	@GetMapping("/{id}")

	public ResponseEntity<Object> showAll(@PathVariable Long id) {
		Students saved = repo.getById(id);
		if (saved == null) {
			return new ResponseEntity<Object>("INVALID", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(saved, HttpStatus.ACCEPTED);
	}

	@GetMapping("/dob")
	public ResponseEntity<Object> dobRange(@RequestParam("start") Date start, @RequestParam("end") Date end) {
		List<Students> sList = repo.dobRange(start, end);
		if (sList == null || sList.isEmpty()) {
			return new ResponseEntity<Object>("Empty Data", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(sList, HttpStatus.ACCEPTED);
	}

	@GetMapping("/{id}/{id1}")
	public ResponseEntity<Object> marksRange(@PathVariable("id") Short start, @PathVariable("id1") Short end) {
		List<Students> sList = repo.marksRange(start, end);
		if (sList == null || sList.isEmpty()) {
			return new ResponseEntity<Object>("INVAILD", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(sList, HttpStatus.ACCEPTED);

	}

	@GetMapping
	public ResponseEntity<Object> getAll() {
		System.out.println("endpoint hit");
		List<Students> sList = repo.showAll();
		if (sList == null || sList.isEmpty()) {
			return new ResponseEntity<Object>("EMPTY", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Object>(sList, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		int del = repo.delete(id);
		if (del == 0) {
			return new ResponseEntity<Object>("INVAILD", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(del, HttpStatus.ACCEPTED);

	}
	@GetMapping("/")
	public String students () {
		return "<!DOCTYPE html>    "
				
			; 	
				}
}
