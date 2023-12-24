/**
 * A peak element is an element that is strictly greater than its neighbors.

	Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
	
	You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
	
	You must write an algorithm that runs in O(log n) time.
	
	 
	
	Example 1:
	
	Input: nums = [1,2,3,1]
	Output: 2
	Explanation: 3 is a peak element and your function should return the index number 2.
	Example 2:
	
	Input: nums = [1,2,1,3,5,6,4]
	Output: 5
	Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class PeakElement {

    // Main method to test the findPeakElement function
    public static void main(String[] args) {
        // Test case
        int[] nums = {1, 2, 3, 1};
        PeakElement peakElementFinder = new PeakElement();
        int result = peakElementFinder.findPeakElement(nums);
        System.out.println("Peak element index: " + result); // Expected Output: 2 (index of element 3)
    }

    // Method to find the peak element in an array
    public int findPeakElement(int[] nums) {
        // Check for edge cases if array length is 1 or 2
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        // Perform binary search to find the peak element
        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is the peak element
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // if mid value is greater than mid-1 value then peak must be on right side for sure
            if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            } 
            // if mid value is less than mid-1 value then peak must be on right side for sure
            else {
                high = mid - 1;
            }
        }

        return -1; // If no peak element found
    }
}

