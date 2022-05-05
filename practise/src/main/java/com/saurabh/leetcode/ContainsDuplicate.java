package com.saurabh.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	 int count=0;
	public boolean duplicate (int arr[]) {
		
		 Set<Integer> uniqueset=new HashSet<>();
		 for(int n:arr) {
			
			 if(uniqueset.contains(n)) {
				 count++;
				 return true;
			 }
			 else
				 uniqueset.add(n);
		 }
		
		/*for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i] == arr[j])
					return true;
			}
		}*/
		return false;
	}
	
	 public static void main(String[] args) {
			int arr[] = {1,2,4,1,3};
			ContainsDuplicate ContainsDuplicate =  new ContainsDuplicate();
			System.out.println(ContainsDuplicate.duplicate(arr));
			System.out.println(ContainsDuplicate.count);
		}


}
