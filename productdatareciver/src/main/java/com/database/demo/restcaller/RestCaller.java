package com.database.demo.restcaller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.database.demo.pojo.product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class RestCaller implements Caller {

	@Autowired
	@Qualifier("resttemplate")
	RestTemplate template;

	@Value("${test.url}")
	private String url;

	public List<product> getAll() {
		try {
		String plist = template.getForObject(url, String.class);
		List<product> prd;
		
		
			prd = new ObjectMapper().readValue(plist, new TypeReference<List<product>>() {
			});
			for(product p:prd) {
			System.out.println(p.getPrice());
			}
			return prd;
		}catch (IllegalArgumentException e) {
			
		} catch (JsonMappingException e) {

			e.printStackTrace();
			return null;
		} catch (JsonProcessingException e) {

			e.printStackTrace();
			return null;
		}
		return null;

	}

	public void save(product p) {
		template.postForObject("http://localhost:9099/products", p, Integer.class);
		
	}

	public void update(product p) {
		template.put("http://localhost:9099/products/update", p, product.class);
	}

	public product getById(Long id) {
		product p = template.getForObject("http://localhost:9099/products/" + id, product.class);
		return p;
	}

	public void delete(long id) {
		template.delete("http://localhost:9099/products/" + id);
	}

}
