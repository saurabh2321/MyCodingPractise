package com.saurabh.leetcode;

public class OddEvenThread extends Thread {

	Integer start;
	Integer N;
	Boolean isEven;
	Printer print;

	public OddEvenThread(Integer start, Integer N, Boolean isEven, Printer print) {

		this.start = start;
		this.N = N;
		this.isEven = isEven;
		this.print = print;

	}

	@Override
	public void run() {

		while (start <= N) {
			if (isEven) {
				print.evenPrinter(start);
			} else {
				print.oddPrinter(start);
			}
			start = start + 2;
		}
	}
}

	class Printer {

		public volatile boolean isOdd = false;

		public synchronized void oddPrinter(int num) {
			if (isOdd) {
				try {
					wait();
					System.out.println("wait odd");
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
			System.out.println(Thread.currentThread().getName() + " ->"+num);
			isOdd = true;
			notify();

		}

		public synchronized void evenPrinter(int num) {

			if (!isOdd) {
				try {
					wait();
					System.out.println("wait even");
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
			System.out.println(Thread.currentThread().getName() + " ->"+num);
			isOdd = false;
			notify();
		}

	}
