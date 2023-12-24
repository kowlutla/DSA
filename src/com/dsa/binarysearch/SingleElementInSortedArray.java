/**
 * 	You are given a sorted array consisting of only integers where every element appears exactly twice, 
 * 	except for one element which appears exactly once.

	Return the single element that appears only once.
	
	Your solution must run in O(log n) time and O(1) space.
	
	 
	
	Example 1:
	
	Input: nums = [1,1,2,3,3,4,4,8,8]
	Output: 2
	Example 2:
	
	Input: nums = [3,3,7,7,10,11,11]
	Output: 10
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class SingleElementInSortedArray {

    // Main method to test the singleNonDuplicate function
    public static void main(String[] args) {
        // Test case
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        SingleElementInSortedArray singleElementFinder = new SingleElementInSortedArray();
        int result = singleElementFinder.singleNonDuplicate(nums);
        System.out.println("Single non-duplicate element: " + result); // Expected Output: 2
    }

    // Method to find the single non-duplicate element in a sorted array
    public int singleNonDuplicate(int[] nums) {
        // Check for edge cases if array length is 1 or 2
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums[0] != nums[1]) {
            return nums[0];
        }

        int n = nums.length;
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        // Perform binary search
        int low = 1, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if the current element is the single non-duplicate
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // Adjust pointers based on the property of the single non-duplicate
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || 
                (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // If no single non-duplicate found
    }
}
