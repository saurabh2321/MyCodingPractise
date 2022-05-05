package com.saurabh.ds;

import java.util.Arrays;

public class CountingSort {
	
	public void sort (int[] arr) {
		
		int[] temp =  new int[11];
		for(int i=0;i<arr.length;i++) {
			temp[arr[i]] = temp[arr[i]]+1;
		}
		System.out.println("temp array with count"+Arrays.toString(temp));
		int curr = 0;
		
		for(int i=0; i<temp.length;i++) {
			for(int j=0;j<temp[i];j++) {
				arr[curr] = i;
				curr++;
			}
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr = new int[] { 3, 10, 2, 4, 2, 6, 9, 5, 7, 2, 8, 10, 3, 9 };
		CountingSort sort = new CountingSort();
		sort.sort(arr);
		System.out.println("Sorted array: " +Arrays.toString(arr));
	}

}
