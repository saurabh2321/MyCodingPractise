package com.saurabh.ds;

import java.util.Arrays;

public class MergeSorter {

	private void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			
			int mid = (int) Math.floor(start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			System.out.println(" merge the sorted halves: " + Arrays.toString(arr));
			System.out.println("enter merge");
			merge(arr, start, mid, end);
		}
	}

	private void merge(int arr[], int start, int mid, int end) {


		// Find sizes of two subarrays to be merged
		int sizeOfLeft = mid - start + 1;
		int sizeOfRight = end - mid;

		int[] left = new int[sizeOfLeft];
		int[] right = new int[sizeOfRight];

		/* Copy data to temp arrays */

		for (int i = 0; i < sizeOfLeft; i++) {
			left[i] = arr[start + i];
		}
		for (int j = 0; j < sizeOfRight; j++) {
			right[j] = arr[mid + 1 + j];
		}
		
		System.out.println("left: "+Arrays.toString(left));
		System.out.println("right: "+Arrays.toString(right));

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;
		// Initial index of merged subarray array
		int k = start;

		while (i < sizeOfLeft && j < sizeOfRight) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		/* Copy remaining elements of L[] if any */
		while (i < sizeOfLeft) {
			arr[k] = left[i];
			i++;
			k++;
		}
		/* Copy remaining elements of R[] if any */
		while (j < sizeOfRight) {
			arr[k] = right[j];
			j++;
			k++;
		}
	}

	public static void main(String args[]) {

		MergeSorter sorter = new MergeSorter();
		int arr[] = { 12, 11, 13, 7, 6, 5 };
		System.out.println("Unsorted Array: " + Arrays.toString(arr));
		sorter.mergeSort(arr, 0, arr.length - 1);
		System.out.println("Sorted Array: " + Arrays.toString(arr));
	}

}
