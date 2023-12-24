/**
	Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
 * 
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class MinimumInSortedRotatedArray {

    // Main method to test the findMin function
    public static void main(String[] args) {
        // Create an instance of the class
        MinimumInSortedRotatedArray minFinder = new MinimumInSortedRotatedArray();

        // Test case
        int[] nums = {4, 5, 6, 7, -1, 1, 2};
        int result = minFinder.findMin(nums);
        System.out.println("Minimum element: " + result); // Expected Output: 0
    }

    // Method to find the minimum element in a rotated sorted array
    public int findMin(int[] nums) {
        // Initialize pointers and answer variable
        int low = 0, high = nums.length - 1, ans = Integer.MAX_VALUE;

        // Perform binary search
        while (low <= high) {
            // If the left pointer element is less than or equal to the right pointer element
            if (nums[low] <= nums[high]) {
                ans = Math.min(nums[low], ans); // Update answer with the minimum of left and answer
                break; // Exit the loop since the array is sorted
            }
            // Calculate the middle index
            int mid = low + (high - low) / 2;

            // If left pointer element is less than or equal to middle pointer element
            if (nums[low] <= nums[mid]) {
                ans = Math.min(nums[low], ans); // Update answer with the minimum of left and answer
                low = mid + 1; // Move left pointer to the right half
            } else {
                ans = Math.min(nums[mid], ans); // Update answer with the minimum of middle and answer
                high = mid - 1; // Move right pointer to the left half
            }
        }
        return ans; // Return the minimum element found
    }
}

