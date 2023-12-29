/**
 * 	Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
	Return the kth positive integer that is missing from this array.
	
	Example 1:
	
	Input: arr = [2,3,4,7,11], k = 5
	Output: 9
	Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
	Example 2:
	
	Input: arr = [1,2,3,4], k = 2
	Output: 6
	Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class KthMissingPositiveNumber {

    // Method to find the kth missing positive number in the array (linear search type)
    public int findKthPositive1(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                k++; // shift k by 1 step if the current element is smaller or equal to k
            } else {
                break; // Break the loop if the current array element exceeds k
            }
        }
        return k;
    }

    // Method to find the kth missing positive number in the sorted array (more efficient approach using binary search)
    public int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the middle index

            // Calculate the count of missing numbers between index 0 and mid
            int missingNumbersCount = arr[mid] - (mid + 1);

            if (missingNumbersCount < k) {
                low = mid + 1; // If missing numbers count is less than k, search the right subarray
            } else {
                high = mid - 1; // If missing numbers count is greater than or equal to k, search the left subarray
            }
        }

        return k + high + 1; // Return the kth missing positive number by adding k to high + 1
        // Alternatively, it can be returned as `low + k`
    }

    // Example usage in a main method
    public static void main(String[] args) {
        KthMissingPositiveNumber solution = new KthMissingPositiveNumber();
        int[] arr = {2, 3, 4, 7, 11}; // Sample array
        int k = 5; // Value of k

        // Using the less efficient approach
        int result1 = solution.findKthPositive1(arr, k);
        System.out.println("Using findKthPositive1 method: " + result1);

        // Using the more efficient approach (binary search)
        int result2 = solution.findKthPositive(arr, k);
        System.out.println("Using findKthPositive method: " + result2);
    }
}
