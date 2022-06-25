package com.saurabh.leetcode;

public class FooBar {

	private int n;
	// flag =0 foo to be printed, flag =1 bar to be printed
	private int flag = 0;

	public FooBar(int n) {
		this.n = n;
	}

	public void foo() throws InterruptedException {

		for (int i = 0; i < n; i++) {
			synchronized (this) {
				while (flag == 1)
					wait();
				System.out.print("foo");
				flag = 1;
				notify();
			}
		}
	}

	public void bar() throws InterruptedException {

		for (int i = 0; i < n; i++) {
			synchronized (this) {
				while (flag == 0)
					wait();
				System.out.print("bar ");
				flag = 0;
				notify();
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {

		FooBar fb = new FooBar(3);
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					fb.foo();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					fb.bar();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

	}

}
