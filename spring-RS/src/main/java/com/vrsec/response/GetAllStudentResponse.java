package com.vrsec.response;

import java.util.ArrayList;
import java.util.List;

import com.indusind.dto.Student;

public class GetAllStudentResponse {

	List<Student> studList = null;

	public List<Student> getStudList() {
		if(null != studList)
		return studList;
		return new ArrayList<Student>();
	}

	public void setStudList(List<Student> studList) {
		this.studList = studList;
	}
	
	
}
