package com.saurabh.leetcode;

import java.util.Arrays;

//Find the minimum and maximum amount to buy all N candies
public class CandiesMinAndMax {

	public static int findMin(int[] arr, int k, int n) {

		int amount = 0;

		for (int i = 0; i < n; i++) {
			amount = amount + arr[i];

			// and take k most expensive candies for free from last
			n = n - k;
		}
		return amount;

	}

	public static int findMax(int[] arr, int k, int n) {

		int amount = 0;
		int index = 0;
		for (int i = n - 1; i >= index; i--) {
			amount = amount + arr[i];

			// and take k least expensive candies for free from the starting
			index = index + k;
		}
		return amount;
	}

	public static void main(String[] args) {

		int[] arr = {3, 2, 1, 4};
		// sort array prices to arrange from min to max
		Arrays.sort(arr);
		int n = arr.length;
		System.out.println(findMin(arr, 2, n) + " " + findMax(arr, 2, n));
	}

}
