package com.saurabh.leetcode;

public class MaxSubarray {
	
    public int maxSubArray(int[] nums) {
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum=sum + nums[i];
            if(nums[i]>sum){
                sum=nums[i];
            }
            maxSum=Math.max(sum,maxSum);
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
		int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		MaxSubarray MaxSubarray =  new MaxSubarray();
		System.out.println(MaxSubarray.maxSubArray(arr));
}


}
