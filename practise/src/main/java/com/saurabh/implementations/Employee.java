package com.saurabh.implementations;

public final class Employee {

	final String panCardNumber;
	
	public Employee(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}
	
	public String getPanCardNumber(){
		return this.panCardNumber;
	}
}
