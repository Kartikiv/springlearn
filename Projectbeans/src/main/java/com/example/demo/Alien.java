package com.example.demo;

public class Alien implements LivingThings {
	private int start;
  public Alien(int start) {
	  this.start=start;
  }
	@Override
	public String start() {
		// TODO Auto-generated method stub
	   return start+"";
	}

}
