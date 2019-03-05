package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.vrsec.dao.CollegeDAOImpl;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages={"com"},exclude={CollegeDAOImpl.class})
@EnableAutoConfiguration
public class SpringRsApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRsApplication.class, args);
	}

}

