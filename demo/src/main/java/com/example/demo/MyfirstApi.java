package com.example.demo;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
@Component
public class MyfirstApi {
	
	public static String map(int a) {
		 HashMap<Integer,String>kar=new HashMap<>();
		   kar.put(1,"Monday");
		   kar.put(2,"Tuesday");
		   kar.put(3,"Wednesday");
		   kar.put(4,"Thusrday");
		   kar.put(5,"Friday");
		   kar.put(6,"Saturday");
		   kar.put(0,"Sunday");
		return kar.get(a);
		
	}
	
@GetMapping("/database/{id}")
public String databases(@PathVariable String id) throws ClassNotFoundException, SQLException{
	myFirstJDBC myFirstJDBC=new myFirstJDBC();
	System.out.println(id);
return myFirstJDBC.nameret(id);}
@GetMapping("/time")
public String timeOfTheDay() {
	return "The time Now is: "+new Date();
	
}
@GetMapping("/day")
public String error() {
	
	return "Please enter a Date in the URL";
}
@GetMapping("/day/{id}")
public String dayName(@PathVariable("id")@DateTimeFormat(pattern = "dd-MM-yyyy")  Date id1) {
    
	
	SimpleDateFormat kk=new SimpleDateFormat("dd-MM-yyyy");
	String id =kk.format(id1);
	System.out.println(id);
	kk.setLenient(false);
	if(id.equals(""))
		return "Not a valid date";
	 try
	    {
	        Date javaDate = kk.parse(id); 
	       
	    }
	    
	    catch (ParseException e)
	    {
	       
	        return "Not valid a valid date";
	    }
	 String[] ddmmyy=id.split("-");
	 
	
	   
	    int d=Integer.parseInt(ddmmyy[0]); 
	    int m=Integer.parseInt(ddmmyy[1]);
	    int y=Integer.parseInt(ddmmyy[2]);
	        int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
	        if (m < 3)
	            y--;
	        int a= (y + y / 4 - y / 100 + y / 400 + t[m - 1]
	                + d)
	            % 7;
	        return "The day on "+id+" is: "+ map(a);
	    
}
}
/*
 * package com.myfirstspring;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyHelloController {
	
	@GetMapping("/hihello")
	public String sayHello()
	{
		return "Hi Hello the time is "+new Date();
	}

}
 */
