package com.testskill.db.events;

import org.springframework.stereotype.Component;

import com.testskill.db.entity.Test;

@Component
public class TestTakenEvent {
private Test test;

public Test getTest() {
	return test;
}

public void setTest(Test test) {
	this.test = test;
}

public TestTakenEvent(Test test) {
	super();
	this.test = test;
}

public TestTakenEvent() {
	super();
}

}
