package com.saurabh.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	
	public boolean wordBreak(String s, List<String> wordDict) {
        boolean [] breakable = new boolean[s.length()+1];
        Set<String> dict = new HashSet<>(wordDict);
        breakable[0] = true;

        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(breakable[j]&&dict.contains(s.substring(j,i))){
                    breakable[i] = true;
                    break;
                }
            }
        }
        return breakable[s.length()];
    }
	
	  public static void main(String[] args) {
		String s = "applepenapple";
		String [] wordDict = {"apple","pen"};
		WordBreak WordBreak =  new WordBreak();
		System.out.println(WordBreak.wordBreak(s,Arrays.asList(wordDict)));
	}

}
