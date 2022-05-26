package com.saurabh.implementations;

import java.util.HashMap;
import java.util.Map;

public class ImmutableDemo {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("1","one");
		map.put("2","two");
		Employee employee = new Employee("ABC123", map);
		System.out.println("Pan NBR: " +employee.getPanCardNumber());
		System.out.println(employee.getMap());
		map.put("3", "three");
		System.out.println(employee.getMap());
	}
}
