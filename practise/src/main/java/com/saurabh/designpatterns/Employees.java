package com.saurabh.designpatterns;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {
	
	private List<String> empList;
	
	public Employees() {
		empList = new ArrayList<>();
	}
	
	public Employees(List<String> empList) {
		this.empList = empList;
	}
	
	public List<String> getEmpList(){
		return empList;
	}
	
	public void loadData() {
		empList.add("John");
		empList.add("Alex");
		empList.add("Peter");
	}
	
	@Override
	public Object clone() {
		List<String> temp = new ArrayList<>();
		temp.addAll(this.empList);
		return new Employees(temp);
	}

}
