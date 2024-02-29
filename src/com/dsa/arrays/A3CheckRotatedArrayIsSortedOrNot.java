/**
 * 	Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.
	There may be duplicates in the original array.
	Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.
	
	Example 1:
	Input: nums = [3,4,5,1,2]
	Output: true
	Explanation: [1,2,3,4,5] is the original sorted array.
	You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].

	Example 2:
	Input: nums = [2,1,3,4]
	Output: false
	Explanation: There is no sorted array once rotated that can make nums.

	Example 3:
	Input: nums = [1,2,3]
	Output: true
	Explanation: [1,2,3] is the original sorted array.
	You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
 */
package com.dsa.arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class A3CheckRotatedArrayIsSortedOrNot {

    // Method to check if a rotated array is sorted
    // Parameters:
    // - nums: the input integer array
    // Returns: true if the rotated array is sorted, false otherwise
    // Time Complexity: O(n) - linear time complexity where n is the number of elements in the array
    // Space Complexity: O(1) - constant space complexity as only a few variables are used
    public boolean check(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) { // Iterate through the array
            if (nums[i] > nums[i + 1]) { // If the current element is greater than the next element
                // Conditions to check if the array is sorted after rotation
            	//nums[i]<nums[0] - if left array of small element is not sorted
                //nums[i+1]>nums[n-1] - if right array small element is not sorted
                //nums[0]<nums[n-1] - in rotated array last element always less than first element
            	if (nums[i] < nums[0] || nums[i + 1] > nums[n - 1] || nums[0] < nums[n - 1]) {
                    return false; // If any condition fails, return false
                }
            }
        }
        return true; // If loop completes without returning false, array is sorted, return true
    }

    // Main method to test the check method
    public static void main(String[] args) {
        A3CheckRotatedArrayIsSortedOrNot checker = new A3CheckRotatedArrayIsSortedOrNot();
        int[] nums = {3, 4, 5, 1, 2}; // Sample input rotated array

        // Call the check method and print the result
        System.out.println("Is the rotated array sorted? " + checker.check(nums));
    }
}
