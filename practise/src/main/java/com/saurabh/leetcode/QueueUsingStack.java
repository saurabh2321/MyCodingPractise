package com.saurabh.leetcode;

import java.util.Stack;

public class QueueUsingStack {
	
	private Stack<Integer> s1 = new Stack<>();
	private Stack<Integer> s2 = new Stack<>();
	private int front;
	
	public void push(int x) {
		
		if(s1.isEmpty())
			front =x;
		
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		s2.push(x);
		
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	
	public void pop() {
		
		s1.pop();
		if(!s1.isEmpty()) {
			front = s1.peek();
		}
	}
	
	public int peek() {
		  return front;
	}
	
	 public static void main(String[] args)
	    {
		 QueueUsingStack s = new QueueUsingStack();
	        s.push(1);
	        s.push(2);
	        s.push(3);
	 
	        System.out.println(s.peek());
	        s.pop();
	        System.out.println(s.peek());
	        s.pop();
	        System.out.println(s.peek());
	 
	    }

}
