
/**
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.

 

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class SearchInSortedRotatedArray2 {

    // Main method to test the search function
    public static void main(String[] args) {
        // Create an instance of the class
        SearchInSortedRotatedArray2 search = new SearchInSortedRotatedArray2();

        // Test case 1
        int[] nums1 = {2, 5, 6, 0, 0, 1, 2};
        int target1 = 0;
        boolean result1 = search.search(nums1, target1);
        System.out.println("Target " + target1 + " found: " + result1); // Expected Output: true

        // Test case 2
        int[] nums2 = {2, 5, 6, 0, 0, 1, 2};
        int target2 = 3;
        boolean result2 = search.search(nums2, target2);
        System.out.println("Target " + target2 + " found: " + result2); // Expected Output: false
    }

    // Method to search for a target value in a rotated sorted array with duplicates
    public boolean search(int[] nums, int target) {
        // Initialize low and high pointers
        int low = 0, high = nums.length - 1;

        // Perform binary search
        while (low <= high) {
            // Calculate mid index
            int mid = low + (high - low) / 2;

            // If target found at mid, return true
            if (nums[mid] == target) {
                return true;
            }

            // Handling case where nums[low], nums[mid], and nums[high] are all equal
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++; // Move low pointer ahead
                high--; // Move high pointer behind
                continue; // Continue to the next iteration
            }

            // Check if left half is sorted
            if (nums[low] <= nums[mid]) {
                // Check if target falls within the sorted left half
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1; // Adjust high pointer to search left half
                } else {
                    low = mid + 1; // Adjust low pointer to search right half
                }
            } else { // Right half is sorted
                // Check if target falls within the sorted right half
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1; // Adjust low pointer to search right half
                } else {
                    high = mid - 1; // Adjust high pointer to search left half
                }
            }
        }

        // Target not found in the array, return false
        return false;
    }
}