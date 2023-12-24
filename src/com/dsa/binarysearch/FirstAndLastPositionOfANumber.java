/**
 *
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class FirstAndLastPositionOfANumber {

	// Method to find the starting and ending positions of the target value in
	// the array
	public int[] searchRange(int[] nums, int target) {
		// Initialize an array to store the result
		int[] result = new int[2];

		// Find the first occurrence of the target
		int first = binarySearch(nums, 0, nums.length - 1, target, true);

		// If the target is not found, return [-1, -1]
		if (first == -1) {
			result[0] = -1;
			result[1] = -1;
			return result;
		}

		// Find the last occurrence of the target
		int last = binarySearch(nums, 0, nums.length - 1, target, false);

		// Store the first and last positions of the target in the result array
		result[0] = first;
		result[1] = last;
		return result;
	}

	// Binary search helper method to find the first or last occurrence of the
	// target
	private int binarySearch(int[] nums, int start, int end, int target,
			boolean first) {
		int result = -1;

		// Perform binary search
		while (start <= end) {
			int mid = start + (end - start) / 2;

			// If the target is found
			if (nums[mid] == target) {
				result = mid;

				// Adjust the search space based on the 'first' flag
				if (first) {
					end = mid - 1; // Search towards the left for the first
									// occurrence
				} else {
					start = mid + 1; // Search towards the right for the last
										// occurrence
				}

			} else if (nums[mid] < target) {
				start = mid + 1; // Discard the left half
			} else {
				end = mid - 1; // Discard the right half
			}
		}
		return result;
	}

	// Main method for testing
	public static void main(String[] args) {
		FirstAndLastPositionOfANumber search = new FirstAndLastPositionOfANumber();

		// Test case 1
		int[] nums1 = {5, 7, 7, 8, 8, 10};
		int target1 = 8;
		int[] result1 = search.searchRange(nums1, target1);
		printResult(result1); // Expected Output: [3, 4]

		// Test case 2
		int[] nums2 = {5, 7, 7, 8, 8, 10};
		int target2 = 6;
		int[] result2 = search.searchRange(nums2, target2);
		printResult(result2); // Expected Output: [-1, -1]

		// Test case 3
		int[] nums3 = {};
		int target3 = 0;
		int[] result3 = search.searchRange(nums3, target3);
		printResult(result3); // Expected Output: [-1, -1]
	}

	// Utility method to print the result array
	private static void printResult(int[] result) {
		System.out.print("Output: [");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
			if (i != result.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}

	private int binarySearchFirst(int[] nums, int start, int end, int target) {
		int result = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				result = mid;
				end = mid - 1;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return result;
	}

	private int binarySearchLast(int[] nums, int start, int end, int target) {
		int result = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				result = mid;
				start = mid + 1;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return result;
	}
}
