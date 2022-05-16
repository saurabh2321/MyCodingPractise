package com.saurabh.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumberDisapperedINArray {
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
		int[] res = new int[nums.length + 1];

		for (int num : nums) {
			res[num] = num;
		}

		List<Integer> result = new ArrayList<>(res.length);
		for (int i = 1; i < res.length; i++) {
			if (res[i] == 0) {
				result.add(i);
			}
		}

		return result;
	}
	
	public static void main(String[] args) {
		
		NumberDisapperedINArray NumberDisapperedINArray = new NumberDisapperedINArray();
		 int a[] = new int[] {4,3,2,7,8,2,3,1};
		 System.out.println(NumberDisapperedINArray.findDisappearedNumbers(a));
	}


}
