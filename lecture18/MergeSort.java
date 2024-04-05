/**
 * Merge sort for an array of int's 
 * 
 * Inspired by: https://algs4.cs.princeton.edu/22mergesort/Merge.java.html
 */

import java.util.Arrays; 

public class MergeSort {

	/**
     * Rearranges the array in ascending order, using the natural order.
     * @param arr the array to be sorted
     */
	public static void mergeSort(int a[]) {
		// Create an auxillary array 
		int[] aux = new int[a.length]; 
		mergeSorthelper(a, aux, 0, a.length-1);

	}

	public static void mergeSorthelper(int[] a, int[] aux, int lo, int hi){
		// Base case 
		if (hi <= lo) return;

		// Find midpoint 
		int mid = lo + (hi - lo) / 2;

		// Divide into two subarray 
		mergeSorthelper(a, aux, lo, mid);
        mergeSorthelper(a, aux, mid + 1, hi);

        //Merge 
        merge(a, aux, lo, mid, hi);
	}

	/**
	 * @pre arr[lo .. mid] and arr[mid+1 .. hi] are sorted subarrays
	 * @post a[lo .. hi] is sorted
	 */
	public static void merge(int[] a, int[] aux, int lo, int mid, int hi){
		// Copy everything currenluy in a to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // Merge back to a[] sorted 
        int i = lo;
        int j = mid+1;

        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (aux[j]< aux[i])       a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
	}

	public static void main(String[] args){
		int arr[] = {38, 27, 43, 3, 9, 82, 10};

		System.out.println("Original Array");
	    System.out.println(Arrays.toString(arr));

	    mergeSort(arr);

	    System.out.println("Sorted array");
	    System.out.println(Arrays.toString(arr));
	}
}