package com.saurabh.leetcode;

public class QueueUsingLinkedList {
	
	Node rear =null, front =null;
	
	public int dequeue() {
		
		if (front == null)
			return -1;
		
		Node temp = front;
		front  = front.next;
		
		if(front == null)
			rear = null;
		return temp.data;
	}
	
	public void enqueue(int data) {
		
		Node node = new Node(data);
		
		if(front == null) {
			front = node;
			rear = node;
		}
		else {
			rear.next = node;
			rear = node;
		}
	}

}
