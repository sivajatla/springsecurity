package com.example.demo;


import java.util.ArrayList;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.MultipartConfig;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/vrsecstaffmgmt")
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
		System.out.println(staff.getName());;
		return staff.getName();
	}
	
	//giving raw data in the form of id="value"&name="jkj" then only populating values or else through html formsubmit
	@RequestMapping(value = "/saveProfileReqRaw",consumes=MediaType.APPLICATION_FORM_URLENCODED,method=RequestMethod.POST)
	@Produces(MediaType.APPLICATION_ATOM_XML)
	public Staff saveProfile(@FormParam("id") String id,@FormParam("name") String name) {
		Staff staff = new Staff(id,name);
		return staff;
	}
	
	
		@RequestMapping(value = "/saveProfileFormData",consumes=MediaType.MULTIPART_FORM_DATA,method=RequestMethod.POST)
		@Produces(MediaType.APPLICATION_ATOM_XML)
		public Staff saveProfileFormData(@FormParam("id") String id,@FormParam("name") String name) {
			Staff staff = new Staff(id,name);
			return staff;
		}
	
	
	@RequestMapping(value = "/saveProfileReqJson", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public Staff saveProfileJsonReq(@RequestBody Staff staff) {
		staff.setName(staff.getName() + "ack");
		System.out.println("inside saveProfile content type json");
		return staff;
	}
	 
}
