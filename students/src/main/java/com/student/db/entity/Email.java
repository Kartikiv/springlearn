package com.student.db.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Email {
@Id
private String id;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}
}

