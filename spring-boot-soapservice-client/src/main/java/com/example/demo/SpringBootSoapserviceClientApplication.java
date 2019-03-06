package com.example.demo;

import org.springframework.boot.SpringApplication;
import javax.xml.ws.Service;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.wsdl2java.ISoapWebService;
import com.example.demo.wsdl2java.SoapControllerService;

@SpringBootApplication
public class SpringBootSoapserviceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapserviceClientApplication.class, args);
		SoapControllerService service = new SoapControllerService();
		ISoapWebService call = service.getSoapControllerPort();
		String res = call.getEmployee();
		System.out.println("res::"+res);
		
	}

}
