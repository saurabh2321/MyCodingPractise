package com.saurabh.implementations;

public class Deadlock {

	public static void main(String[] args) {

		String resource1 = "resource1";
		String resource2 = "resource2";

		Thread t1 = new Thread() {
			public void run() {
				synchronized (resource1) {
					System.out.println("Thread 1 locked resource 1");
					synchronized (resource2) {
						System.out.println("Thread 1 locked resource 2");
					}
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				synchronized (resource2) {
					System.out.println("Thread 2 locked resource 2");
					synchronized (resource1) {
						System.out.println("Thread 2 locked resource 1");
					}
				}
			}
		};

		t1.start();
		t2.start();
	}
}