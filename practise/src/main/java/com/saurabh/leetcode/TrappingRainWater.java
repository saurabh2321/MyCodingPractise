package com.saurabh.leetcode;

public class TrappingRainWater {
	/*
	// Function to return the maximum
	// water that can be stored
	public static int maxWater(int[] arr, int n)
	{
	     
	    // To store the maximum water
	    // that can be stored
	    int res = 0;
	 
	    // For every element of the array
	    // except first and last element
	    for(int i = 1; i < n - 1; i++)
	    {
	         
	        // Find maximum element on its left
	        int left = arr[i];
	        for(int j = 0; j < i; j++)
	        {
	            left = Math.max(left, arr[j]);
	        }
	 
	        // Find maximum element on its right
	        int right = arr[i];
	        for(int j = i + 1; j < n; j++)
	        {
	            right = Math.max(right, arr[j]);
	        }
	 
	        // Update maximum water value
	        res += Math.min(left, right) - arr[i];
	    }
	    return res;
	}
	 */

	 // Method for maximum amount of water in o(n)
    static int maxWater(int arr[], int n)
    {
        // left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int left[] = new int[n];
 
        // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        int right[] = new int[n];
 
        // Initialize result
        int water = 0;
 
        // Fill left array
        left[0] = arr[0];
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i - 1], arr[i]);
 
        // Fill right array
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], arr[i]);
 
        // Calculate the accumulated water element by element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i] .
        for (int i = 0; i < n; i++)
            water += Math.min(left[i], right[i]) - arr[i];
 
        return water;
    }
	
	// Driver code
	public static void main(String[] args)
	{
	    int[] arr = { 3, 0, 2, 1, 4 };
	    int n = arr.length;
	 
	    System.out.print(maxWater(arr,n));
	}

}
