package com.saurabh.leetcode;

public class RearrangeDigitandAlphbetsAdjacent {
	
	static String rearrange(String s)
	{
	  // Stores alphabets and digits
	  String s1 = "", s2 = "", ans = "";
	  char []s3 = s.toCharArray();
	 
	  // Store the alphabets and digits
	  // separately in the Strings
	  for (char x : s3)
	  {
	    if(x >= 'a' && x <= 'z')
	      s1 += x ;
	    else
	      s2 += x;
	  }
	 
	  // Stores the length of
	  // alphabets and digits
	  int n = s1.length();
	  int m = s2.length();
	 
	  // If respective counts
	  // differ by 1
	  if (Math.abs(n - m) > 1)
	 
	    // Desired arrangement
	    // not possible
	    return "-1";
	 
	  // Stores the indexes
	  int i = 0, j = 0;
	 
	  // Check if first character
	  // should be alphabet or digit
	  int flag = (n >= m) ? 1 : 0;
	 
	  // Place alphabets and digits
	  // alternatively
	  while ((i < n && n>=m) || (j < m && m>=n))
	  {
	    // If current character
	    // needs to be alphabet
	    if (flag != 0)
	      ans += s1.charAt(i++);
	 
	    // If current character
	    // needs to be a digit
	    else
	      ans += s2.charAt(j++);
	 
	    // Flip flag for alternate
	    // arrangement
	    if(flag == 1)
	      flag = 0;
	    else
	      flag = 1;
	  }
	 
	  // Return resultant String
	  return ans;
	}
	 
	// Driver Code
	public static void main(String[] args)
	{
	  // Given String
	  String str = "geeks2020";
	 
	  // Function Call
	  System.out.print(rearrange(str) + "\n");
	}
	}

