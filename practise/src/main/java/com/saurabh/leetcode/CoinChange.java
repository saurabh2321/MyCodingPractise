package com.saurabh.leetcode;

import java.util.Arrays;

public class CoinChange {
	
	 public int coinChange(int[] coins, int amount) {
		    int max = amount + 1;
		    int[] dp = new int[amount + 1];
		    Arrays.fill(dp, max);
		    dp[0] = 0;
		    for (int i = 1; i <= amount; i++) {
		      for (int coinValue : coins) {
		        if (coinValue <= i) {
		          dp[i] = Math.min(dp[i], dp[i - coinValue] + 1);
		        }
		      }
		    }
		    return dp[amount] > amount ? -1 : dp[amount];
		  }
	 
	    public static void main(String[] args) {
				int arr[] = {1,2,5};
				CoinChange CoinChange =  new CoinChange();
				System.out.println(CoinChange.coinChange(arr, 11));
		}

}
