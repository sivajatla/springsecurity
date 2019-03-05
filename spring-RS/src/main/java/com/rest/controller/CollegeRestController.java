package com.rest.controller;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.college.service.CollegeServiceImpl;
import com.college.service.ICollegeService;
import com.sun.research.ws.wadl.HTTPMethods;
import com.vrsec.response.GetAllStudentResponse;

@RestController
public class CollegeRestController {

@Autowired
ICollegeService collegeServiceImpl;

//@GetMapping
@RequestMapping(value="/getAllStudent",method=RequestMethod.GET)
public GetAllStudentResponse getAllStudent() {
	ICollegeService collegeServiceImple = new CollegeServiceImpl();
	GetAllStudentResponse response = collegeServiceImple.getAllStudents();
	//GetAllStudentResponse response = collegeServiceImpl.getAllStudents();
	return response;
}

@RequestMapping(value="/updateStudent",method=RequestMethod.POST)
public ResponseEntity<String> updateStudent(@PathParam("studID") String studId) {
	ResponseEntity<String> response = new ResponseEntity<String>("student updated", HttpStatus.OK);
	
	
	return response;
}


}
