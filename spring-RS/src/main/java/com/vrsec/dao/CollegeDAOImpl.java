package com.vrsec.dao;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

@Component
public class CollegeDAOImpl implements ICollegeDAO{

	public String studentUpdate(){
		return "stud update";
	}
}
