package com.saurabh.leetcode;

import java.util.HashMap;

public class LongestSubstringNonrepeating {
	
	public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int right=0, left=0; right<s.length(); ++right){
        	char ch = s.charAt(right);
            if (map.containsKey(ch)){
                left = Math.max(left,map.get(ch)+1);
            }
            map.put(ch,right);
            max = Math.max(max,right-left+1);
        }
        return max;
    }

	public static void main(String[] args) {
		String s  = "pwwkew";
		LongestSubstringNonrepeating LongestSubstringNonrepeating = new LongestSubstringNonrepeating();
		System.out.println(LongestSubstringNonrepeating.lengthOfLongestSubstring(s));
	}

}
