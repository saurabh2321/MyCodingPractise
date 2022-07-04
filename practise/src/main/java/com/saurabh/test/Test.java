package com.saurabh.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		
		List<Integer> list =  Arrays.asList(2,1,5,8,4,7,6);
		
		System.out.println(list.stream().max(Comparator.naturalOrder()).get());
		System.out.println(list.stream().min(Integer::compare).get());
		
	}

}
