package com.database.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ProductdatahandleApplication {
	 List<VendorExtension> vendorExtensions = new ArrayList<>();
	 private Contact c =new Contact("karthik", "linc", "test@gmail.com");
	@Bean
	public Docket swagger() {
		
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfo("kartik", "product database", "2.0", "linc", c, "apache lincense", "linc", vendorExtensions)).select().apis(RequestHandlerSelectors.basePackage("com.database.demo.controller"))
				.paths(PathSelectors.any()).build();

	}

	public static void main(String[] args) {
		SpringApplication.run(ProductdatahandleApplication.class, args);
	}

}
