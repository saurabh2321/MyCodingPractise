package com.saurabh.dsApps;

import com.saurabh.ds.BasicQueue;

public class QueueApp {
	
	

	public static void main(String[] args) {
		
		BasicQueue<Integer> queue =  new BasicQueue<Integer>(5);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		System.out.println("front:"+queue.front());
		System.out.println("rear:"+queue.rear());
		
		System.out.println("current size is :" +queue.size());
		queue.dequeue();
		System.out.println("current size is :" +queue.size());
		System.out.println("front:"+queue.front());
		System.out.println("rear:"+queue.rear());
		
		queue.enqueue(60);
		System.out.println("current size is :" +queue.size());
		System.out.println("front:"+queue.front());
		System.out.println("rear:"+queue.rear());
		
		

	}

}
