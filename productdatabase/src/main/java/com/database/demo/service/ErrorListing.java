package com.database.demo.service;

public class ErrorListing {
 private String errorName;
 private String errorCode;
 public  ErrorListing(int x) {
	 if(x==1) {
		 setErrorCode("404");
		 setErrorName("name already present");
	 }
	 if(x==2) {
		 setErrorCode("402");
		 setErrorName("Wrong Input");
		 
	 }
	 if(x==3) {
		 setErrorCode("401");
		 setErrorName("Wrong Input of Price");
		 
	 }
	 if(x==4) {
		 setErrorCode("401");
		 setErrorName("Empty Databases add data"); 
	 }
 }
public String getErrorName() {
	return errorName;
}
public void setErrorName(String errorName) {
	this.errorName = errorName;
}
public String getErrorCode() {
	return errorCode;
}
public void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
}

}
