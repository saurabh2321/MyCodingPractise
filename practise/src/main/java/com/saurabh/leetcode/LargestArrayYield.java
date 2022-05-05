package com.saurabh.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestArrayYield {
	
	public String findLargestNumber(List<Integer> nums) {
		
		Collections.sort(nums, new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				String ba = String.valueOf(b) + a;
				String ab = String.valueOf(a) + b;
				return ba.compareTo(ab);
			}
		});
		String s="";
		for(Integer i : nums) {
			 s = s+String.valueOf(i);
		}
		return s;
	}
		
		

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(10, 68, 75, 7, 21, 12 );
		LargestArrayYield LargestArrayYield = new LargestArrayYield();
		System.out.println(LargestArrayYield.findLargestNumber(nums));
	}

}
