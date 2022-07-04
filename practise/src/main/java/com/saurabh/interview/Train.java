package com.saurabh.interview;

import java.util.Arrays;

public class Train {
	
	//take every interval 1 by 1 and find nbr of intervals that overlap
	//then we would save the max nbr of intervals thats overalp with an interval and return max
	
	//first loop will be start to end and inner loop will be i+1 to end
	//for every iteration of outer loop , get the count of intervals that intersect with current interval
	//update my result with max count of overalp in each iteration of outer loop
	
	//second approach
	//first sort arrival and departure arrays
	//two pointers i,j
	//ans, current count of platopform
	//loop thorugh sorted arrays
	//compare arrival and departure while iterating
	//if arrival < = departure, then increase the count
	//if arrival > departure , then decrement the count
	// result will be max of and and platform count
	
	public int  findPlatform(int arr[], int dep[]) {
		
		int n = arr.length;
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		int res =1, i =0, j=0;
		int platform = 1;
		
		while(i<n && j<n) {
			if(arr[i] <= dep[i]) {
				platform++;
				i++;
			} else if(arr[i] > dep[j]) {
				platform--;
				j++;
			}
		if(platform > res) {
			res = platform;
		}
		}
		return res;
	}

	

}
