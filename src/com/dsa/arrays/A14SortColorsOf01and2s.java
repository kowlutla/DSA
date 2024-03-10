/**
 * 	Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
	We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
	You must solve this problem without using the library's sort function.
	
	Example 1:
	Input: nums = [2,0,2,1,1,0]
	Output: [0,0,1,1,2,2]
	
	Example 2:
	Input: nums = [2,0,1]
	Output: [0,1,2]
	
	Constraints:
	
	n == nums.length
	1 <= n <= 300
	nums[i] is either 0, 1, or 2.
	 
 */
package com.dsa.arrays;

import java.util.ArrayList;

/**
 * @author KowlutlaSwamy
 *
 */
public class A14SortColorsOf01and2s {

	  /**
	   * Sorts an array containing only 0s, 1s, and 2s using counting (brute force) approach.
	   * Time complexity: O(N) due to a single pass through the array for counting and another pass for filling the array.
	   * Space complexity: O(1) as it uses constant extra space for variables (zeros, ones, twos).
	   *
	   * @param arr The ArrayList containing integers (0, 1, or 2).
	   * @param n The size of the ArrayList.
	   */
	  public static void sortColors1(ArrayList<Integer> arr, int n) {

	    int zeros = 0;
	    int ones = 0;
	    int twos = 0;

	    // Count occurrences of each color
	    for (int num : arr) {
	      switch (num) {
	        case 0:
	          zeros++;
	          break;
	        case 1:
	          ones++;
	          break;
	        case 2:
	          twos++;
	          break;
	        default:
	          // Handle unexpected values (optional)
	          break;
	      }
	    }

	    int index = 0;

	    // Fill the array with sorted colors based on counts
	    while (zeros-- > 0) {
	      arr.set(index++, 0);
	    }

	    while (ones-- > 0) {
	      arr.set(index++, 1);
	    }

	    while (twos-- > 0) {
	      arr.set(index++, 2);
	    }
	  }

	  /**
	   * Sorts an array containing only 0s, 1s, and 2s using a two-pointer (Dutch National Flag) approach.
	   * Time complexity: O(N) as it iterates through the array at most twice.
	   * Space complexity: O(1) as it uses constant extra space for variables (low, mid, high).
	   *
	   * @param arr The ArrayList containing integers (0, 1, or 2).
	   * @param n The size of the ArrayList.
	   */
	  public static void sortColors2(ArrayList<Integer> arr, int n) {

	    int low = 0, mid = 0, high = n - 1;

	    // Partition the array using three pointers (low, mid, high)
	    while (mid <= high) {
	      if (arr.get(mid) == 0) { // Swap 0s to the beginning
	        swap(arr, low, mid);
	        low++;
	        mid++;
	      } else if (arr.get(mid) == 1) { // Move mid forward for 1s (already in correct position)
	        mid++;
	      } else { // Swap 2s to the end
	        swap(arr, mid, high);
	        high--;
	      }
	    }
	  }

	  // Helper method for swapping elements in the ArrayList
	  private static void swap(ArrayList<Integer> arr, int index1, int index2) {
	    int temp = arr.get(index1);
	    arr.set(index1, arr.get(index2));
	    arr.set(index2, temp);
	  }

	  // Main method for testing
	  public static void main(String[] args) {
	    ArrayList<Integer> arr = new ArrayList<>();
	    arr.add(2);
	    arr.add(0);
	    arr.add(1);
	    arr.add(2);
	    arr.add(1);
	    arr.add(0);

	    System.out.println("Original array: " + arr);

	    sortColors1(arr, arr.size());
	    System.out.println("Sorted array using sortColors1: " + arr);

	    arr = new ArrayList<>(); // Reset the array for sortColors2
	    arr.add(2);
	    arr.add(0);
	    arr.add(1);
	    arr.add(2);
	    arr.add(1);
	    arr.add(0);

	    System.out.println("Original array: " + arr);

	    sortColors2(arr, arr.size());
	    System.out.println("Sorted array using sortColors2: " + arr);
	  }
	}
