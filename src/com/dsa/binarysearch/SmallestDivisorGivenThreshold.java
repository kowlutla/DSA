/**
	Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. 
	Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
	Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
	The test cases are generated so that there will be an answer.
	
	 
	
	Example 1:
	
	Input: nums = [1,2,5,9], threshold = 6
	Output: 5
	Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
	If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 
	Example 2:
	
	Input: nums = [44,22,33,11,1], threshold = 5
	Output: 44
 * 
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class SmallestDivisorGivenThreshold {

    // Method to find the smallest divisor using linear search
    public int smallestDivisor1(int[] nums, int threshold) {
        // Finding the minimum and maximum values in the array
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Iterating from 1 to max to find the smallest divisor
        for (int i = 1; i <= max; i++) {
            int sum = 0;

            // Calculating the sum using divisor i
            for (int j = 0; j < nums.length; j++) {
                sum += Math.ceil((double) nums[j] / (double) i);
            }

            if (sum <= threshold) {
                return i; // Return the smallest divisor found
            }
        }

        return -1; // No divisor found within the threshold
    }

    // Method to find the smallest divisor using binary search
    public int smallestDivisor(int[] nums, int threshold) {
        // Finding the maximum value in the array
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int ans = -1;
        int low = 1, high = max;

        // Binary search to find the smallest divisor
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if it's possible to have divisor 'mid'
            if (isPossible(nums, threshold, mid)) {
                ans = mid; // Update potential answer
                high = mid - 1; // Search in the lower range
            } else {
                low = mid + 1; // Search in the higher range
            }
        }
        return ans; // Return the smallest divisor found
    }

    // Helper method to check if it's possible to have a divisor within threshold
    private boolean isPossible(int[] nums, int threshold, int div) {
        int result = 0;

        // Calculate the sum using divisor 'div'
        for (int num : nums) {
            result += Math.ceil((double) num / (double) div);
        }
        return result <= threshold; // Return true if the sum is within the threshold
    }

    // Main method for testing the smallestDivisor methods
    public static void main(String[] args) {
        // Example array and threshold
        int[] nums = { 1,2,5,9 };
        int threshold = 6;

        // Create an instance of the class
        SmallestDivisorGivenThreshold divisorFinder = new SmallestDivisorGivenThreshold();

        // Test both methods and display the results
        int result1 = divisorFinder.smallestDivisor1(nums, threshold);
        System.out.println("Smallest divisor using linear search: " + result1);

        int result2 = divisorFinder.smallestDivisor(nums, threshold);
        System.out.println("Smallest divisor using binary search: " + result2);
    }
}
