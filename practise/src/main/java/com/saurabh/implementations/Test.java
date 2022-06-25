package com.saurabh.implementations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test {
	
	public static void main(String[] args) {
		
		String s= "saurabh";
				int hash = (int)s.charAt(0);
		System.out.println(hash);
		int n = 16;
		int index = hash & (n-1);
		System.out.println(index);
		
			
	
	List<String> list = Arrays.asList("one", "two");
	
	Optional<String> opt = list.stream().findFirst();
	System.out.println(opt.isPresent() ? opt.get() : "not found");
	
	
	}
}
