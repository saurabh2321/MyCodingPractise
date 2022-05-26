package com.saurabh.implementations;

import java.util.HashMap;
import java.util.Map;

public final class Employee {

	private final String panCardNumber;
	private final Map<String, String> map;
	
	public Employee(String panCardNumber, Map<String, String> map) {
		this.panCardNumber = panCardNumber;
		//deep copy
		Map<String, String> tempMap = new HashMap<>();
		for(Map.Entry<String, String> entry : map.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		this.map = tempMap;
	}
	
	
	
	public String getPanCardNumber(){
		return this.panCardNumber;
	}
	
	public Map<String, String> getMap(){
		Map<String, String> tempMap = new HashMap<>();
		for(Map.Entry<String, String> entry : this.map.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		return tempMap;
	}
}
