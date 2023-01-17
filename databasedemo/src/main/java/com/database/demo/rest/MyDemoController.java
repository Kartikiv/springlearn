package com.database.demo.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.database.demo.enties.Students;
import com.database.demo.resoures.JdbcConnector;

@RestController
public class MyDemoController {
	@Autowired
	JdbcConnector kar;

	@GetMapping("/say")
	public String hell() {

		return "hi";
	}

	@GetMapping("/addm/{id}/{id1}/{id2}/{id3}")
	public void add(@PathVariable("id") String id, @PathVariable("id1") String name, @PathVariable("id2") String jdate,
			@PathVariable("id3") String roln) {
        int a =Integer.parseInt(id);
		Students s1 = new Students(a, name, jdate, roln);
		kar.saveStud(s1);
	}
	@GetMapping("/delm/{id}/{id1}/{id2}/{id3}")
	public void delStud(@PathVariable("id") String id, @PathVariable("id1") String name, @PathVariable("id2") String jdate,
			@PathVariable("id3") String roln) {
		int a =Integer.parseInt(id);
		Students s1 = new Students(a, name, jdate, roln);
		kar.delStud(a);
		
	}
	@GetMapping("/showdb")
	public List<Students> show(){
		return kar.showstudent();
	
	}
	@GetMapping("/shwstu/{id}")
	public List<Students> listem(@PathVariable String id){
		int a =Integer.parseInt(id);
		return kar.showuserById1(a);
		
	}
	@GetMapping("/upd/{id}")
	public void upd(@PathVariable String id){
		int a =Integer.parseInt(id);
		kar.updatestudents(null);
	
	}
}
