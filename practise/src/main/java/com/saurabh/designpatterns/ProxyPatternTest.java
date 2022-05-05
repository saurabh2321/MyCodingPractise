package com.saurabh.designpatterns;

public class ProxyPatternTest {

	public static void main(String[] args) {
		
		OfficeInternetAccess access = new ProxyInternetAccess("Saurabh Singh");
		access.grantInternetAccess();

	}

}
