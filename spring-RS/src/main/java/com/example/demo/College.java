package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class College {
  private List<Staff> staffList = new ArrayList<Staff>();

public List<Staff> getStaffList() {
	return staffList;
}

public void setStaffList(List<Staff> staffList) {
	this.staffList = staffList;
}
  
}
