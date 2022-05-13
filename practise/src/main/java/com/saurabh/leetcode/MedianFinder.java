package com.saurabh.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
	
	 static PriorityQueue<Integer> maxHeap = null;
	  static PriorityQueue<Integer> minHeap = null;
	    /** initialize your data structure here. */
	    public MedianFinder() {
	    maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	    minHeap = new PriorityQueue<>();
	    }
	    
	    public void addNum(int num) {
	    	System.out.println("adding "+num);
	         minHeap.add(num);
	    maxHeap.add(minHeap.poll());
	    if (maxHeap.size() > minHeap.size()) {
	      minHeap.add(maxHeap.poll());
	    }
	    }
	    
	    public double findMedian() {
	          if (minHeap.size() > maxHeap.size()) {
	      return minHeap.peek();
	    }
	        double a = (double) (maxHeap.peek() + minHeap.peek()) / 2;

	    return a;
	    }

	public static void main(String[] args) {

		MedianFinder MedianFinder = new MedianFinder();
		MedianFinder.addNum(2);
		System.out.println("minHeap: "+minHeap.toString());
		System.out.println("maxHeap: "+maxHeap.toString());
		System.out.println("median: "+MedianFinder.findMedian());
		System.out.println();
		MedianFinder.addNum(3);
		System.out.println("minHeap: "+minHeap.toString());
		System.out.println("maxHeap: "+maxHeap.toString());
		System.out.println("median: "+MedianFinder.findMedian());
		System.out.println();
		MedianFinder.addNum(4);
		System.out.println("minHeap: "+minHeap.toString());
		System.out.println("maxHeap: "+maxHeap.toString());
		System.out.println("median: "+MedianFinder.findMedian());
		System.out.println();
		/*
		 * MedianFinder.addNum(5); System.out.println("minHeap: "+minHeap.toString());
		 * System.out.println("maxHeap: "+maxHeap.toString());
		 * System.out.println("median: "+MedianFinder.findMedian());
		 */
	}

}
