package com.saurabh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> lists = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();

		Arrays.sort(nums);
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[k]);

					if (!set.contains(list)) {
						lists.add(list);
						set.add(list);
					}
					j++;
					k--;
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		return lists;
	}

	public static void main(String[] args) {
		int arr[] = {-1,0,1,2,-1,-4};
		ThreeSum ThreeSum = new ThreeSum();
		System.out.println(ThreeSum.threeSum(arr));
	}

}
