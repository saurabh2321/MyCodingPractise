package com.saurabh.leetcode;

import java.util.Arrays;

public class ProductOfArraySelf {

	 public int[] productExceptSelf(int[] nums) {
	        int n = nums.length;
	        // leftProduct[i] is product of numbers to the left of i.
	        int[] leftProduct = new int[n];
	        // rightProduct[i] is product of numbers to the right of i.
	        int[] rightProduct = new int[n];
	        // productExceptSelf[i] is product of array except self.
	        int[] productExceptSelf = new int[n];
	        
	        //Please note that nums[0] doesn't have elements to its left, and nums[n-1] doesn't have elements to its right. Thus
	        leftProduct[0] = 1; // Without numbers to its left.
	        rightProduct[n - 1] = 1; // Without numbers to its right.
	        
	        for (int i = 1; i < n; i++) {
	            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
	        }
	        for (int i = n - 2; i >= 0; i--) {
	            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
	        }
	        for (int i = 0; i < n; i++) {
	        	// product of numbers to the left of nums[i] * product of numbers to the right of nums[i]
	            productExceptSelf[i] = leftProduct[i] * rightProduct[i]; 
	        }
	        
	        return productExceptSelf;
	    }
		    
		
		public static void main(String[] args) {
			int arr[] = {1,2,3,4};
			ProductOfArraySelf ProductOfArraySelf =  new ProductOfArraySelf();
			ProductOfArraySelf.productExceptSelf(arr);
	}

}
