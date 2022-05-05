package com.saurabh.leetcode;

class TestThread {
	
	public static void main(String[] args) {
		
		Printer printer = new Printer();
	
	OddEvenThread t1 = new OddEvenThread(1, 10, false, printer);
	OddEvenThread t2 = new OddEvenThread(2, 10, true, printer);
	System.out.println("Thread exceution starts...");
	t1.start();
	t2.start();
	}
}

