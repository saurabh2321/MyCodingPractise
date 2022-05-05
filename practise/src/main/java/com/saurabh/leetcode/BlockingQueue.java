package com.saurabh.leetcode;

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
				producer.await();
			}
			queue.add(x);
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
				consumer.await();
			}
			int x = queue.removeFirst();
			producer.signal();
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
		queue.remove();
		queue.add(3);
	}

}
