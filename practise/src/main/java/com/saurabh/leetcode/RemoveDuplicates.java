package com.saurabh.leetcode;

import java.util.Arrays;

public class RemoveDuplicates {
	
	public static void removeduplicates(int arr[], int n){
	    Arrays.sort(arr);  
	    int j = 0;
	    for ( int i = 0; i < n-1 ; i++) {
	        if (arr[i] != arr[i+1]) {
	            arr[j++] = arr[i];
	        }
	    }
	    arr[j++] = arr[n - 1];
	    
	    for ( int i = 0; i < j ; i++) {
	    	System.out.print(arr[i] + " ");
	    }
	 
	}
	
	public static void main(String[] args) {
		
		 RemoveDuplicates removeDuplicates = new RemoveDuplicates();
		 int a[] = new int[] {1,2,2,4,5,4,7,8,7,3,6};
		removeduplicates(a, a.length) ;
	}

}
