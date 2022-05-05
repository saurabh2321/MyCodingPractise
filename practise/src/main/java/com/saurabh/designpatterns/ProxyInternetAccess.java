package com.saurabh.designpatterns;

public class ProxyInternetAccess implements OfficeInternetAccess {

	private String empName;
	private RealInternetAccess realAccess;

	public ProxyInternetAccess(String empName) {
		this.empName = empName;
	}

	@Override
	public void grantInternetAccess() {
		if (getRole(empName) > 4) {
			realAccess = new RealInternetAccess(empName);
			realAccess.grantInternetAccess();
		} else {
			System.out.println("No Internet access granted. Your job level is below 5");
		}
	}

	public int getRole(String empName) {

		return 7;
	}

}
