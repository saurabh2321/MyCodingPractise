package com.saurabh.leetcode;

import java.util.Arrays;

public class ProductOfArraySelf {

		public int[] productExceptSelf(int[] nums) {
		    int leng = nums.length;
		    int[] a = new int[leng];
		    Arrays.fill(a,1);
		   /* int runningprefix = 1;
		    for(int i = 0; i < leng; i++){
		        ret[i] = runningprefix;
		        runningprefix*= nums[i];
		    }
		    System.out.println(Arrays.toString(ret));
		    int runningsufix = 1;
		    for(int i = leng -1; i >= 0; i--){
		        ret[i] *= runningsufix;
		        runningsufix *= nums[i];
		    }
		    System.out.println(Arrays.toString(ret));
		    return ret;*/
		    
		    int product = 1;
		    for (int i = nums.length - 1; i > 0; i--) {
		      product = product * nums[i];
		      a[i - 1] = product;
		    }
		    System.out.println(Arrays.toString(a));
		    product = 1;

		    for (int i = 0; i < nums.length - 1; i++) {
		      product = product * nums[i];
		      a[i + 1] = product * a[i + 1];
		    }
		    System.out.println(Arrays.toString(a));
		    return a;
		 
		    }
		    
		
		public static void main(String[] args) {
			int arr[] = {1,2,3,4};
			ProductOfArraySelf ProductOfArraySelf =  new ProductOfArraySelf();
			ProductOfArraySelf.productExceptSelf(arr);
	}

}
