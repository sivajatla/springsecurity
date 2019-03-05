package com.example.demo;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.apache.http.client.methods.HttpHead;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
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
			url = new URI("http://SPRING-RS/spring-rs/vrsecstaffmgmt/user");
			res =restTemplate.getForEntity(url, String.class);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	@RequestMapping(value = "/invokeCoreSpringRS", method = RequestMethod.GET)
	public ResponseEntity<Staff> invokeCoreSpringRS() {
		System.out.println("inside invokeCoreSpringRS");
		ResponseEntity<Staff> responseEntity = null;
		try {
			String endUrl = "http://SPRING-RS/spring-rs/vrsecstaffmgmt/saveProfileReqJson";
			Staff staff = new Staff("mic1","callign spring-rs");
			org.springframework.http.HttpHeaders reqhead = new org.springframework.http.HttpHeaders();
			reqhead.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
			
			JSONObject reqJson = new JSONObject();
			reqJson.put("id", new String("eurekhacline"));
			reqJson.put("name", new String("calling spring-rs core"));
			HttpEntity<Staff> reqEntity = new HttpEntity<>(staff,reqhead);
			
			
			responseEntity = restTemplate.exchange(
					endUrl,
	                HttpMethod.POST,
	                reqEntity,
	                Staff.class
	        );
			
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
	            System.out.println("response received");
	            System.out.println(responseEntity.getBody());
	        } else {
	            System.out.println("error occurred");
	            System.out.println(responseEntity.getStatusCode());
	        }
		}
			catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	@Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
