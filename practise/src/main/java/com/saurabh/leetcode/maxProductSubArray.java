package com.saurabh.leetcode;

public class maxProductSubArray {
	
    public int maxProduct(int[] nums) {
      //For each index i keep updating the max and min. We are also keeping min because on multiplying with any negative number 
    	//your min will become max and max will become min .so why not as soon as we encounter negative element, we swap the max and min already.
		/*
		 * if(nums == null || nums.length ==0) return 0;
		 * 
		 * int max = nums[0]; int max_so_far = nums[0]; int min_so_far = nums[0];
		 * 
		 * for(int i=1; i<nums.length; i++) { int temp_max = nums[i] * max_so_far; int
		 * temp_min = nums[i] * min_so_far;
		 * 
		 * max_so_far = Math.max(Math.max(temp_max, temp_min) , nums[i]); min_so_far =
		 * Math.min(Math.min(temp_max, temp_min) , nums[i]); max = Math.max(max,
		 * max_so_far); } return max;
		 */
    	
    	        int max = nums[0], min = nums[0], ans = nums[0];
    	        int n = nums.length;
    	        
    	        for (int i = 1; i < n; i++) {
    	        
    				// Swapping min and max
    	            if (nums[i] < 0){
    	                int temp = max;
    	                max = min;
    	                min = temp;
    	            }
    	            max = Math.max(nums[i], max * nums[i]);
    	            min = Math.min(nums[i], min * nums[i]);
    	            ans = Math.max(ans, max);
    	        }
    	        return ans;
    	    }
	    
	    public static void main(String[] args) {
			int arr[] = {2,3,-2,4};
			maxProductSubArray maxProductSubArray =  new maxProductSubArray();
			System.out.println(maxProductSubArray.maxProduct(arr));
	}


}
