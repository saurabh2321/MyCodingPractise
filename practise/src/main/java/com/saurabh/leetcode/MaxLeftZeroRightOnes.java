package com.saurabh.leetcode;

public class MaxLeftZeroRightOnes {
	
	static int maxSum(String str)
	{
	    int maximumSum = 0;
	 
	    // To store the total ones
	    int totalOnes = 0;
	 
	    // Count the total numbers of ones
	    // in string str
	    for(int i = 0; i < str.length(); i++)
	    {
	       if (str.charAt(i) == '1')
	       {
	           totalOnes++;
	       }
	    }
	     
	    // To store the count of zeros and
	    // ones while traversing string
	    int zero = 0, ones = 0;
	 
	    // Iterate the given string and
	    // update the maximum sum
	    for(int i = 0; i < str.length(); i++)
	    {
	       if (str.charAt(i) == '0')
	       {
	           zero++;
	       }
	       else
	       {
	           ones++;
	       }
	        
	       // Update the maximum Sum
	       maximumSum = Math.max(maximumSum,
	                            zero + (totalOnes - ones));
	    }
	     
	    return maximumSum;
	}
	
	public static void main(String args[])
	{
	     
	    // Given binary string
	    String str = "0011101";
	 
	    // Function call
	    System.out.println(maxSum(str));
	}

}
