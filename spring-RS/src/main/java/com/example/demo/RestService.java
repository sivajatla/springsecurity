package com.example.demo;


import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RestController
public class RestService {

	//@GetMapping(value = "{/getMyName}", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@Produces("text/xml")
	public College getName() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("sova");
		list.add("sovafdfd");
		College college = new College();
		Staff s1 = new Staff("1","siva");
		Staff s2 = new Staff("2","suneel");
		ArrayList<Staff> staffList = new ArrayList<Staff>();
		staffList.add(s1);
		staffList.add(s2);
		college.setStaffList(staffList);
		return college;
	}
	
	
	/*
	 * @PostMapping( consumes = { MediaType.APPLICATION_JSON } )
	 */
	@RequestMapping(value = "/saveStaff", method = RequestMethod.POST)
	public String saveStaff(@RequestBody Staff staff) {
		System.out.println("inside saveStaff");
		System.out.println(staff.getName());
		return staff.getName();
	}
}
