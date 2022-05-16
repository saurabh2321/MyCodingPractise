package com.saurabh.leetcode;

public class EvenOddThreadGFG {

	 int counter = 1;
	static int N;

	public void printOdd() {

		synchronized (this) {
			while (counter < N) {
				if (counter % 2 == 0) {

					try {
						wait();
						System.out.println(Thread.currentThread().getName()+" wait"+counter+" even");
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}

				System.out.println(Thread.currentThread().getName() + " ->" + counter);
				counter++;
				notify();
			}
		}
	}

	public void printEven() {

		synchronized (this) {
			while (counter < N) {
				if (counter % 2 == 1) {

					try {
						wait();
						System.out.println(Thread.currentThread().getName()+" wait"+counter+" odd");
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}

				System.out.println(Thread.currentThread().getName() + " ->" + counter);
				counter++;
				notify();
			}
		}
	}

	public static void main(String[] args) {

		N = 10;
		EvenOddThreadGFG gfg = new EvenOddThreadGFG();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				gfg.printEven();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				gfg.printOdd();
			}
		});

		t1.start();
		t2.start();

	}

}
