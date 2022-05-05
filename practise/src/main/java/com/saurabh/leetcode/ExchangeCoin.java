package com.saurabh.leetcode;

public class ExchangeCoin {
	
	public int exchange(int i) {
		int []arr=new int[10000+1];
			int x =Math.max((i/2 +i/3+i/4),i);
		return x;
	}
	public static void main(String[] args) {
		
		ExchangeCoin ex = new ExchangeCoin();
		System.out.println(ex.exchange(100));
}
}
