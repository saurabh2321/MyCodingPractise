package com.saurabh.designpatterns;


public class RealInternetAccess implements OfficeInternetAccess {
	
	private String empName;
	
	public RealInternetAccess(String empName) {
		this.empName = empName;
	}

	@Override
	public void grantInternetAccess() {
		System.out.println("Internet Access has been granted to "+ empName);
	}
	
	

}
