package com.dsa.arrays;

import java.util.Arrays;

/**
 * Given an array of size N containing only 0s, 1s, and 2s; sort the array in
 * ascending order.
 */
public class SortArrayOf0s1sAnd2s {
	
	// Solution 1 - Counting Sort
	public static void sort012Sol1(int a[], int n) {
		// Array to count occurrences of 0s, 1s, and 2s
		int count[] = new int[3];
		// Count the occurrences of each number
		for (int val : a) {
			count[val]++;
		}
		
		int index = 0;
		int num = 0;
		while (index < n) {
			// Place the numbers in the array according to their counts
			while (count[num]-- > 0) {
				a[index++] = num;
			}
			num++;
		}
	}
	
	// Solution 2 - Counting Zeros, Ones, and Twos
	public static void sort012Sol2(int a[], int n) {
		int zeros = 0;
		int ones = 0;
		int twos = 0;
		
		// Count the occurrences of 0s, 1s, and 2s
		for (int num : a) {
			if (num == 0) {
				zeros++;
			} else if (num == 1) {
				ones++;
			} else {
				twos++;
			}
		}
		
		int index = 0;
		// Place the numbers in the array based on the counts of 0s, 1s, and 2s
		while (zeros-- > 0) {
			a[index++] = 0;
		}
		while (ones-- > 0) {
			a[index++] = 1;
		}
		while (twos-- > 0) {
			a[index++] = 2;
		}
	}
	
	// Solution 3 - Dutch National Flag Algorithm
	public static void sort012Sol3(int a[], int n) {
		int left = 0; // Initialize left pointer
		int mid = 0; // Initialize mid pointer
		int right = n - 1; // Initialize right pointer
		while (mid <= right) {
			if (a[mid] == 0) {
				// Move 0 to the left index
				int temp = a[left];
				a[left] = a[mid];
				a[mid] = temp;
				left++;
				mid++;
			} else if (a[mid] == 2) {
				// Move 2 to the right index
				int temp = a[right];
				a[right] = a[mid];
				a[mid] = temp;
				right--;
			} else {
				mid++;
			}
		}
	}
	
	 // Main method to test the solutions
    public static void main(String[] args) {
        int[] arr1 = { 0, 2, 1, 2, 0 };
        int[] arr2 = { 0, 1, 0 };
        int n1 = arr1.length;
        int n2 = arr2.length;

        // Test solution 1
        sort012Sol1(arr1, n1);
        sort012Sol1(arr2, n2);
        System.out.println("Sorted Array 1 (Solution 1): " + Arrays.toString(arr1));
        System.out.println("Sorted Array 2 (Solution 1): " + Arrays.toString(arr2));

        // Test solution 2
        sort012Sol2(arr1, n1);
        sort012Sol2(arr2, n2);
        System.out.println("Sorted Array 1 (Solution 2): " + Arrays.toString(arr1));
        System.out.println("Sorted Array 2 (Solution 2): " + Arrays.toString(arr2));

        // Test solution 3
        sort012Sol3(arr1, n1);
        sort012Sol3(arr2, n2);
        System.out.println("Sorted Array 1 (Solution 3): " + Arrays.toString(arr1));
        System.out.println("Sorted Array 2 (Solution 3): " + Arrays.toString(arr2));
    }
}
