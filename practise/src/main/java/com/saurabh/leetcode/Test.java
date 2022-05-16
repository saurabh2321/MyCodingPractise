package com.saurabh.leetcode;

public class Test {
	
	public static void main(String[] args) {
		
		String s= "saurabh";
				int hash = (int)s.charAt(0);
		System.out.println(hash);
		int n = 16;
		int index = hash & (n-1);
		System.out.println(index);
	}
	
	

}
