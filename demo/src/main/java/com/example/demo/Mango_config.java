package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mango_config {
	@Bean("alph")
	public Mango Alphnso() {
		return new Mango(1);

	}

	@Bean("Amrp")
	public Mango Amrapali() {
		return  new Mango(2);

	}

	@Bean("Atlf")
	public Mango Ataulfo() {
		return  new Mango(3);

	}

	@Bean("Irw")
	public Mango Irwin() {
		return  new Mango(4);

	}

}
