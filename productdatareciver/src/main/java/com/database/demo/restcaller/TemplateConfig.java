package com.database.demo.restcaller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TemplateConfig {
	@Bean
	@Qualifier("resttemplate")
	public RestTemplate temp() {
		return new RestTemplate();
	}

}
