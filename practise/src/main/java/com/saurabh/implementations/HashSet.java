package com.saurabh.implementations;

import java.util.HashMap;

public class HashSet {

	private HashMap<Object, Object> map;
	private static final Object PRESENT = new Object();
	
	public HashSet() {
		map = new HashMap<>();
	}
	
	public boolean add(String x) {
		return map.put(x, PRESENT) == null;
	}
	
	public static void main(String[] args) {
		
		HashSet set = new HashSet();
		System.out.println(set.add("one"));
		System.out.println(set.add("two"));
		System.out.println(set.add("one"));
	}
}
