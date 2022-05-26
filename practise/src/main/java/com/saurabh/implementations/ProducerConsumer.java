package com.saurabh.implementations;

import java.util.LinkedList;

public class ProducerConsumer {
	

	LinkedList<Integer> list = new LinkedList<>();
	int capacity;
	
	public ProducerConsumer(int capacity) {
		this.capacity = capacity;
	}

	public void produce() throws InterruptedException {
		int value = 0;
		while(true) {
		//for(int i=0; i<5; i++) {
			synchronized (this) {

				while (list.size() == capacity)
					wait();
				System.out.println("Producer produced - " + value);
				list.add(value++);
				notify();
				Thread.sleep(1000);
			}
		}
	}

	public void consume() throws InterruptedException {
		while(true)	{
		//for(int i=0; i<5; i++) {
			synchronized (this) {

				while (list.size() == 0)
					wait();
				int value = list.removeFirst();
				System.out.println("Consumer consumed - " + value);
				notify();
				Thread.sleep(1000);
			}
	}
	}

	public static void main(String[] args) throws InterruptedException {
		
		ProducerConsumer pc = new ProducerConsumer(2);
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					pc.consume();
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
