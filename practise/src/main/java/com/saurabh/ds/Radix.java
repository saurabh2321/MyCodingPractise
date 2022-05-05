package com.saurabh.ds;

import java.util.Arrays;

class Radix {  
	  
int getMax(int a[], int n) {  
   int max = a[0];  
   for(int i = 1; i<n; i++) {  
      if(a[i] > max)  
         max = a[i];  
   }  
   return max; //maximum element from the array  
}  
  
void countingSort(int a[], int n, int place) {// function to implement counting   
  
 
   int[] output = new int[n+1];  
 int[] count = new int[10];  
  
  // Calculate count of elements  
  for (int i = 0; i < n; i++)  
    count[(a[i] / place) % 10]++;  
  System.out.println("count: "+Arrays.toString(count));
      
  // Calculate cumulative frequency  
  for (int i = 1; i < 10; i++)  
    count[i] += count[i - 1];  
  System.out.println("frequesncy: "+Arrays.toString(count));
  
  // Place the elements in sorted order  
  for (int i = n - 1; i >= 0; i--) {  
    output[count[(a[i] / place) % 10] - 1] = a[i];  
    count[(a[i] / place) % 10]--;  
  }  
  
  for (int i = 0; i < n; i++)  
    a[i] = output[i]; 
  System.out.println("pass:"+Arrays.toString(a));
}  
  
// function to implement radix sort  
void radixsort(int a[], int n) {  
   
  // get maximum element from array  
  int max = getMax(a, n);  
  
  // Apply counting sort to sort elements based on place value  
  for (int place = 1; max / place > 0; place *= 10)  
    countingSort(a, n, place);  
}  
  
// function to print array elements  
void printArray(int a[], int n) {  
  for (int i = 0; i < n; ++i)   
    System.out.print(a[i] + " ");  
}  
  
  public static void main(String args[]) {  
	  int a[] = {181, 289, 390, 121, 145, 736, 514, 212};
  int n = a.length;  
  Radix r1 = new Radix();  
  System.out.print("Before sorting array elements are - \n"+Arrays.toString(a));  
  System.out.println();
  r1.radixsort(a, n);  
  System.out.print("\n\nAfter applying Radix sort, the array elements are -  \n"+Arrays.toString(a));  
}  
  }  
