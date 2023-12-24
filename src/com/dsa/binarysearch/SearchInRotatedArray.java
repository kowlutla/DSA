/**
	There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * 
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class SearchInRotatedArray {

	// Method to search for a target value in a rotated sorted array
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;

			// If the middle element is the target, return its index
			if (nums[mid] == target) {
				return mid;
			} else if (nums[left] <= nums[mid]) {
				// Check if the left half is sorted and within the target range

				// If the target falls within the sorted left half, adjust the search to the left
				if (nums[left] <= target && target <= nums[mid]) {
					right = mid - 1;
				} else {
					// Otherwise, adjust the search to the right
					left = mid + 1;
				}
			} else {
				// Right half is sorted and within the target range

				// If the target falls within the sorted right half, adjust the search to the right
				if (nums[mid] <= target && target <= nums[right]) {
					left = mid + 1;
				} else {
					// Otherwise, adjust the search to the left
					right = mid - 1;
				}
			}
		}
		// Target not found in the array
		return -1;
	}
	
	public static void main(String[] args) {
        SearchInRotatedArray search = new SearchInRotatedArray();

        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        int result1 = search.search(nums1, target1);
        System.out.println("Target " + target1 + " found at index: " + result1); // Expected Output: 4

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        int result2 = search.search(nums2, target2);
        System.out.println("Target " + target2 + " found at index: " + result2); // Expected Output: -1
    }
}
