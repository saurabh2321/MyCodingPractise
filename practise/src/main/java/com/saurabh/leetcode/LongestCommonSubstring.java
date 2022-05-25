package com.saurabh.leetcode;

public class LongestCommonSubstring {
	
	  public static int longestCommonSubsequence(String text1, String text2) {           
		    return helper( text1 , text2 ) ;
		}

		private static int helper( String s1 , String s2 ) {
		    if( s1.length() == 0 || s2.length() == 0 ) return 0 ;
		    
		    int val = 0 ;
		    if( s1.charAt(0) == s2.charAt(0) )
		        val = 1 + helper( s1.substring(1) , s2.substring(1) ) ;
		    else {
		        val = Math.max(helper( s1,s2.substring(1)) , helper( s1.substring(1) , s2)) ;
		    }  
		    return val ;
		}
		
		public static void main(String[] args) {
			
			System.out.println(longestCommonSubsequence("abcde", "ace"));
		}

}
