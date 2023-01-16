package com.database.demo.entity;

import java.util.HashSet;

public interface nameAllPresent {
	public HashSet<String> getNameList();

	public void setNameList(HashSet<String> nameList);

	public void addName(String name);

	public boolean isPresentName(String name);
	public String getName(String name);
	public void deleteName(String name);
}
