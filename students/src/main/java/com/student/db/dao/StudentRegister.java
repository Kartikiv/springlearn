package com.student.db.dao;

import com.student.db.entity.Students;

public class StudentRegister {
private Students s;
public StudentRegister() {
	
}
public StudentRegister(Students s) {
	this.s=s;
}
public Students getS() {
	return s;
}

public void setS(Students s) {
	this.s = s;
}
}
