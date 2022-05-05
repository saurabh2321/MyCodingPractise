package com.saurabh.leetcode;

public class maxProductSubArray {
	
    public int maxProduct(int[] nums) {
        
        if(nums == null || nums.length ==0) 
            return 0;
        
        int max = nums[0];
        int max_so_far =  nums[0];
        int min_so_far =  nums[0];
        
        for(int i=1; i<nums.length; i++) {
            int temp_max = nums[i] * max_so_far;
            int temp_min = nums[i] * min_so_far;
            
            max_so_far = Math.max(Math.max(temp_max, temp_min) , nums[i]);
            min_so_far = Math.min(Math.min(temp_max, temp_min) , nums[i]);
            max = Math.max(max, max_so_far);
        }
        return max;
}
	    
	    public static void main(String[] args) {
			int arr[] = {2,3,-2,4};
			maxProductSubArray maxProductSubArray =  new maxProductSubArray();
			System.out.println(maxProductSubArray.maxProduct(arr));
	}


}
