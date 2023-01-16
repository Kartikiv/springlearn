package com.database.demo.entity;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("namelist")
public class NameList implements nameAllPresent {
	private static HashSet<String> nameList = new HashSet<>();

	public HashSet<String> getNameList() {
		return nameList;
	}

	public void addName(String name) {
		nameList.add(name);
	}
	public String getName(String name) {
		if(nameList.contains(name)) {
			return name;
		}
		return null;
	}
	public void deleteName(String name) {
		if(nameList.contains(name)) {
			 nameList.remove(name);
		}
	}

	public boolean isPresentName(String name) {
		return (nameList.contains(name));

	}

	public void setNameList(HashSet<String> nameList) {
		NameList.nameList = nameList;
	}

}
