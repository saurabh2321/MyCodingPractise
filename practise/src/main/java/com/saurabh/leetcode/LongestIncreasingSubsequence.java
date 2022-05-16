package com.saurabh.leetcode;

public class LongestIncreasingSubsequence {
	
	public static int lengthOfLIS(int[] nums) {
	    if(nums==null || nums.length==0){
	        return 0;
	    }
	    int[] dp = new int[nums.length];
	    int max = 1;
	    for(int index=0; index<nums.length;index++){
	        dp[index]=1;
	        for(int dpIndex=0; dpIndex<index; dpIndex++){
	            if(nums[dpIndex]<nums[index]){
	                dp[index]=Math.max(dp[index],dp[dpIndex]+1);
	                max=Math.max(dp[index],max);
	            }
	        }
	    }
	    return max;
	}
	
	public static void main(String[] args) {
		
		System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
	}

}
