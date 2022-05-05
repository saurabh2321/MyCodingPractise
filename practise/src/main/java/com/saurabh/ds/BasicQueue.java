package com.saurabh.ds;

public class BasicQueue<X> {
	
	private int [] arr;
	private int front;
	private int rear;
	int capacity;
	int count;
	
	public BasicQueue (int size) {
		 
		arr = new int[size];
		capacity = size;
		front = 0;
		rear = -1;
		count =0;
		
	}
	
	public int size() {
		return count;
	}
	
	public boolean isEmpty () {
		return (size() == 0);
	}
	
	public boolean isFull () {
		return (size() == capacity);
	}
	
	public void enqueue (int item) {
		
		if(isFull()) {
			throw new IllegalStateException("cannot enqueue since queue is Full)");
		}
		
		System.out.println("Inserting: " + item);
		rear = (rear +1) % capacity;
		arr[rear] = item;
		count ++;
	}
	
	public int dequeue() {
		
		if(isEmpty()) {
			throw new IllegalStateException("cannot dequeue since queue is empty)");
		}
		
		int x = arr[front];
		System.out.println("Removing " + x);
		front = (front + 1) % capacity;
		count --;
		
		return x;
	}
	
	public int front () {
		 return this.front;
	}
	
	public int rear () {
		 return this.rear;
	}
	
	public boolean contains(int item) {
		
		boolean found = false;
		if(size() == 0) {
			found = false;
		}
		
		for (int i= front; i< rear; i++) {
			 if (arr[i] == (item)) {
				 found = true;
				 break;
			 }
		}
		 return found;
	}
	
	public int access (int position) {
		
		 if (size() == 0 || position > size()) {
			 throw new IllegalArgumentException("Queue is empty or position greater than size of the queue");
		 }
		 int trueIndex =0;
		 for (int i=front; i<rear ; i++) {
			 if(trueIndex == position) {
				 return arr[i];
			 }
			 trueIndex++;
		 }
		 throw new IllegalArgumentException("Could not get queue item at position :" + position);
	}
	

}
