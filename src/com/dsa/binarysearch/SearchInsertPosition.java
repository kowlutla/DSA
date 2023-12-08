package com.dsa.binarysearch;

/**
 * Given a sorted array of distinct integers and a target value, this class
 * provides a method to return the index where the target is found or where it
 * would be inserted in order.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1: Input: nums = [1,3,5,6], target = 5 Output: 2
 * 
 * Example 2: Input: nums = [1,3,5,6], target = 2 Output: 1
 * 
 * Example 3: Input: nums = [1,3,5,6], target = 7 Output: 4
 * 
 * @author KowlutlaSwamy
 */
public class SearchInsertPosition {
	// Method to find the index where the target is found or would be inserted
	public int searchInsert(int[] nums, int target) {
		
		int start = 0, end = nums.length - 1, result = nums.length;
		
		// Perform binary search to find the position of the target or insertion point
		while (start <= end) {
			int mid = start + (end - start) / 2; // Calculate the middle index
			
			if (nums[mid] >= target) {
				result = mid; // Update result to the current middle index
				end = mid - 1; // Move to the left half
			} else {
				start = mid + 1; // Move to the right half
			}
		}
		
		return result; // Return the index where the target is found or should be inserted
		
	}
	
	// Main method for testing purposes
	public static void main(String[] args) {
		
		SearchInsertPosition sip = new SearchInsertPosition();
		
		int[] nums = { 1, 3, 5, 6 };
		int target1 = 5;
		int target2 = 2;
		int target3 = 7;
		
		// Find the index where the target is found or would be inserted for each case
		int index1 = sip.searchInsert(nums, target1);
		int index2 = sip.searchInsert(nums, target2);
		int index3 = sip.searchInsert(nums, target3);
		
		// Display the results
		System.out.println("For target 5, Index: " + index1);
		System.out.println("For target 2, Index: " + index2);
		System.out.println("For target 7, Index: " + index3);
		
	}
}
