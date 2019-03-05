package com.college.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indusind.dto.Student;
import com.vrsec.dao.CollegeDAOImpl;
import com.vrsec.dao.ICollegeDAO;
import com.vrsec.response.GetAllStudentResponse;

@Service
public class CollegeServiceImpl implements ICollegeService{
	
	//@Autowired
	ICollegeDAO collegeDAOImpl = new CollegeDAOImpl();
	
	public GetAllStudentResponse getAllStudents(){
		List<Student> studList = new ArrayList<Student>();
		GetAllStudentResponse response = new GetAllStudentResponse();
		response.setStudList(studList);
		System.out.println(collegeDAOImpl.studentUpdate());
		return response;
	}

}
