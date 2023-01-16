package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlienConfig {
    @Bean("al1")
	public Alien Alien1() {
		return new Alien(1);
	}
    @Bean("al2")
	public Alien Alien2() {
		return new Alien(2);
	}
    @Bean ("al3")
	public Alien Alien3() {
		return new Alien(3);
	}
    @Bean("al4")
	public Alien Alien4() {
		return new Alien(4);
	}

}
