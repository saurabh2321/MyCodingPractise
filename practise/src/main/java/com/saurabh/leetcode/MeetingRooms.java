package com.saurabh.leetcode;

//Given an array of meeting time intervals consisting of start and end times [s1, e1], [s2, e2], ..
//determine if a person could attend all meetings.
public class MeetingRooms {
	
		public static boolean canAttend(int[][] intervals){
			if(intervals == null || intervals.length == 0) 
				return true;
			//go through the meetings one by one and make sure that each meeting ends before the next one starts and there is no overlap
			for(int i = 1; i < intervals.length; i++){
				if(intervals[i][0] < intervals[i - 1][1])
					return false;
			}
			return true;
		}
		public static void main(String[] args) {
			int[][] t = {{0, 3}, {5, 10}, {15, 20}};
			System.out.println(canAttend(t));
		}

}
