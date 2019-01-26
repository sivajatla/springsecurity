package com.example.demo;

import javax.xml.ws.Endpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebservicesWarApplication {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/ISoapWebService/employee", new SoapController());
		SpringApplication.run(SpringBootWebservicesWarApplication.class, args);
	}

}

