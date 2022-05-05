package com.saurabh.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {

	public int minMeetingRooms(int[][] intervals) {

		// Sort meetings according to their start times, earlier ones go first.
		// For sake of completeness, secondary condition is meeting duration.
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0])
					return Integer.compare(a[0], b[0]);
				return Integer.compare(a[1], b[1]);
			}
		});

		// Minimum heap, used to track meeting end times.
		// Meetings get added to heap when they start, and are removed once done.
		// The size of the heap tells us the number of meetings going on at present.
		PriorityQueue<Integer> curMeetings = new PriorityQueue<>();

		// The required answer is the maximum number of rooms occupied at any given
		// time.
		int maxRooms = 0;

		for (int i = 0; i < intervals.length; ++i) {
			int startTime = intervals[i][0], endTime = intervals[i][1];

			// Meetings that end before or at the same time as current meeting starts, need
			// to 'release' their rooms.
			while (curMeetings.size() > 0 && curMeetings.peek() <= startTime) {
				curMeetings.remove();
			}

			// Current meeting occupies a room. Add current meeting's end time to heap.
			curMeetings.add(endTime);

			// Update result.
			maxRooms = Math.max(maxRooms, curMeetings.size());

		}

		return maxRooms;
	}

	public static void main(String[] args) {
		int[][] arr = {{ 5, 10 },{ 0, 30},{ 15, 30 } };
		MeetingRoomsII MeetingRoomsII = new MeetingRoomsII();
		System.out.println(MeetingRoomsII.minMeetingRooms(arr));
	}

}
