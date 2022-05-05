package com.saurabh.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
	
	private Queue<Integer> q1 = new LinkedList<>();
	private Queue<Integer> q2 = new LinkedList<>();
	private int top;

	// Push element x onto stack.
	public void push(int x) {
	    q1.add(x);
	    top = x;
	}
	
	public void pop() {
	    while (q1.size() > 1) {
	        top = q1.remove();
	        q2.add(top);
	    }
	    q1.remove();
	    Queue<Integer> temp = q1;
	    q1 = q2;
	    q2 = temp;
	}
	
	public boolean empty() {
	    return q1.isEmpty();
	}
	
	public int top() {
	    return top;
	}
 
    // driver code
    public static void main(String[] args)
    {
    	StackUsingQueue s = new StackUsingQueue();
        s.push(1);
        s.push(2);
        s.push(3);
 
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
 
    }

}
