package com.example.demo;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EurekaCustomClient {

	@Autowired
    RestTemplate restTemplate;
	//@RequestMapping(value = "/getCollegeStaff", method = RequestMethod.GET)
	@GetMapping
	public ResponseEntity<String> getCollegeStaff() {
		System.out.println("inside getCollegeStaff");
		URI url;
		ResponseEntity<String> res = new ResponseEntity<String>(HttpStatus.ACCEPTED);
		try {
			url = new URI("http://SPRING-RS/user");
			res =restTemplate.getForEntity(url, String.class);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	@Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
