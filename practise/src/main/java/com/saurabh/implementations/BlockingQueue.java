package com.saurabh.implementations;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue {
	
	private int capacity;
	private LinkedList<Integer> queue = new LinkedList<Integer>();
	private Lock lock = new ReentrantLock();
	private Condition producer = lock.newCondition();
	private Condition consumer = lock.newCondition();
	
	public BlockingQueue(int capacity) {
		this.capacity = capacity;
	}
	
	public void add(int x) throws InterruptedException {
		lock.lock();
		try {
			while(queue.size() == capacity) {
				System.out.println("Buffer full");
				producer.await();
			}
			queue.add(x);
			System.out.println("added: "+x);
			consumer.signal();
		}
		finally {
			lock.unlock();
		}
	}
	
	public int remove() throws InterruptedException {
		lock.lock();
		try {
			while(queue.size() ==0) {
				System.out.println("Buffer is empty");
				consumer.await();
			}
			int x = queue.removeFirst();
			producer.signal();
			System.out.println("removed: "+x);
			return x;
		}
		finally {
			lock.unlock();
		}
	}
	

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue queue = new BlockingQueue(2);
		queue.add(1);
		queue.add(2);
		//queue.add(4);
		queue.remove();
		queue.add(3);
	}

}
