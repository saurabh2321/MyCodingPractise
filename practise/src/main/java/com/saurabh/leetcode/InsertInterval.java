package com.saurabh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
	
	 public int[][] insert(int[][] intervals, int[] newInterval) {
		 List<int[]> result = new ArrayList<>();        
			int i=0;
			// Step 1 - add all intervals ending before newInterval starts
			while (i<intervals.length && intervals[i][1] < newInterval[0]) {
				result.add(intervals[i]);
				i++;
			}
			

			// Step 2 - update the newInterval by merging with all overlapping intervals
			while (i<intervals.length && intervals[i][0] <= newInterval[1]) {
				newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
				newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
				i++;
			}
			result.add(newInterval); // add updated interval

			// Step 3 - add remaining intervals
			while (i<intervals.length) {
				result.add(intervals[i]);
				i++;
			}
			
			for(int [] arr: result) {
				System.out.print(Arrays.toString(arr));
			}
			return result.toArray(new int[0][2]);
	    }
	 
	  public static void main(String[] args) {
			int [][] arr =  {{1,2},{3,5},{6,7},{8,10}, {12,16}};
			int [] interval =  {4,8};
			InsertInterval InsertInterval =  new InsertInterval();
			InsertInterval.insert(arr, interval);
	}

}
