package com.saurabh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringCountFrequency {
	
	public String[] sort(String arr[]) {
		
		Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		
		for(String s : arr) {
			map.put(s, map.getOrDefault(s, 0) +1);
			list.add(s);
		}
		SortComparator comparator = new SortComparator(map);
		Collections.sort(list, comparator);
		 return list.toArray(new String[arr.length]);
	}
	
	class SortComparator implements Comparator<String>{

		private final Map<String, Integer> freqMap;
		
		public SortComparator( Map<String, Integer> freqMap) {
			
			this.freqMap = freqMap;
		}
		@Override
		public int compare(String o1, String o2) {
			
			int freqCompare = freqMap.get(o2).compareTo(freqMap.get(o1));
			int valueCompare = o1.compareTo(o2);
			
			if(freqCompare == 0)
				return valueCompare;
			else {
				return freqCompare;
			}
		}
		
	}
	

	public static void main(String[] args) {
		
		String[] arr = {"apple", "orange", "apple", "orange", "apple", "kiwi", "kiwi", "grapes", "banana"};
		StringCountFrequency StringCountFrequency = new StringCountFrequency();
		System.out.println(Arrays.toString(StringCountFrequency.sort(arr)));

	}

}
