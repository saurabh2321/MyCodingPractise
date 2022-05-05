package com.saurabh.ds;

import java.util.Arrays;

public class QuickSorter {
	
	public void sort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}
	
	public void quickSort(int[] arr, int start, int end) {
		if(start<end) {
			
			int pivotIndex = partition(arr, start, end);
			quickSort(arr, start, pivotIndex -1);
			quickSort(arr, pivotIndex +1, end);
 		}
	}

	private int partition(int[] arr, int start, int end) {
		
		int pivot =arr[end];
		int i = start;
		for(int j=start;j<=end-1;j++) {
			if(arr[j] < pivot) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
		}
		arr[end] = arr[i];
		arr[i] = pivot;
		return i;
	}
	
	public static void main(String[] args) {
		
		//int arr[] = {12,9,7,15,10};
		int arr[] = {10, 80, 30, 90, 40, 50, 70};
		QuickSorter quickSorter = new QuickSorter();
		quickSorter.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
