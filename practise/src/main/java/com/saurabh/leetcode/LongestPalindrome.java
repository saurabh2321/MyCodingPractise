package com.saurabh.leetcode;

public class LongestPalindrome {
	
	 public String longestPalindrome(String s) {
	       if (s == null) return null;
			String longest = s.substring(0, 1);
			for (int i = 0; i < s.length() - 1; i++) {
				//odd cases like 121
				String palindrome = intermediatePalindrome(s, i, i);
				if (palindrome.length() > longest.length()) {
					longest = palindrome;
				}
				//even cases like 1221
				palindrome = intermediatePalindrome(s, i, i + 1);
				if (palindrome.length() > longest.length()) {
					longest = palindrome;
				}
			}
			return longest; 
	    }
	    
	    public String intermediatePalindrome(String s, int left, int right) {
			if (left > right) return null;
			while (left >= 0 && right < s.length()
					&& s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}
			return s.substring(left + 1, right);
		}
	    
	    public static void main(String[] args) {
			String s =  "cabad";
			LongestPalindrome LongestPalindrome = new LongestPalindrome();
			System.out.println(LongestPalindrome.longestPalindrome(s));

		}

}
