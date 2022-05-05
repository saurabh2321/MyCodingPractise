package com.saurabh.dsApps;

import com.saurabh.ds.BasicHashTable;

public class HashTableApp {
	
	
	
	public static void main(String args[]) {
		
		BasicHashTable<Integer, Integer> hashTablee = new BasicHashTable<>(10);
		
		hashTablee.put(1, 10);
		hashTablee.put(2, 20);
		hashTablee.put(3, 30);
		hashTablee.put(4, 40);
		hashTablee.put(5, 50);
		
		System.out.println(hashTablee.size());
		System.out.println(hashTablee.hasKey(2));
		System.out.println(hashTablee.hasValue(30));
		System.out.println(hashTablee.hasValue(60));
		System.out.println(hashTablee.get(5));
		hashTablee.delete(5);
		System.out.println(hashTablee.size());
		
		
		
	}


}
