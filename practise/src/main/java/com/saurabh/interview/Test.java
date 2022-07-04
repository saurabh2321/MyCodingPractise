package com.saurabh.interview;

import java.util.PriorityQueue;

public class Test {


		public static int findMinCost(int[] arr) {
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			int minCost = 0;
			for(int i = 0; i< arr.length; i++) {
				pq.add(arr[i]);
			}
			
			while(pq.size() > 1) {
				
				int value1 = pq.poll();
				int value2 = pq.poll();
				int costofTwo = value1 + value2;
				minCost = minCost + costofTwo;
				pq.add(costofTwo);
			}
			return minCost;
			
		}
		
		public static void main(String[] args) {
			int arr[] = {4,3,2,6};
			
			System.out.println(findMinCost(arr));
		}
	

}

