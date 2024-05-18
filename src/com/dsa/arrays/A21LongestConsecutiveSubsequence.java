/**
 	Given an array of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, 
 	the consecutive numbers can be in any order.
 	
 	Example 1:
	Input:
	N = 7
	a[] = {2,6,1,9,4,5,3}
	Output:
	6
	Explanation:
	The consecutive numbers here
	are 1, 2, 3, 4, 5, 6. These 6 
	numbers form the longest consecutive
	subsquence.

	Example 2:
	Input:
	N = 7
	a[] = {1,9,3,10,4,20,2}
	Output:
	4
	Explanation:
	1, 2, 3, 4 is the longest
	consecutive subsequence.
 */
package com.dsa.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class A21LongestConsecutiveSubsequence {

    // Method 1: Brute force approach
    // Time Complexity: O(N^2) in the worst case
    // Space Complexity: O(1) for extra space used
    public static int findLongestConseqSubseq1(int[] arr, int N) {
        int maxCount = 0; // To keep track of the maximum length of consecutive subsequence

        // Iterate through each element of the array
        for (int i = 0; i < N; i++) {
            int val = arr[i]; // Start from the current element
            int count = 1; // Initialize the count of consecutive elements

            // Check for the next consecutive elements
            while (isNextPresent(val + 1, arr)) {
                count++;
                val++;
            }

            // Update maxCount if a longer consecutive subsequence is found
            maxCount = Math.max(maxCount, count);
        }
        return maxCount; // Return the length of the longest consecutive subsequence
    }

    // Helper method to check if the next consecutive element is present in the array
    // Time Complexity: O(N) for each call
    // Space Complexity: O(1)
    private static boolean isNextPresent(int val, int[] arr) {
        // Iterate through the array to find the given value
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return true; // Return true if the value is found
            }
        }
        return false; // Return false if the value is not found
    }

    // Method 2: Sorting approach
    // Time Complexity: O(N log N) due to sorting
    // Space Complexity: O(1) for extra space used
    static int findLongestConseqSubseq2(int[] arr, int N) {
        Arrays.sort(arr); // Sort the array

        int maxCount = 1; // To keep track of the maximum length of consecutive subsequence
        int count = 1; // To count the length of the current consecutive subsequence

        // Iterate through the sorted array
        for (int i = 1; i < N; i++) {
            // Skip duplicate elements
            if (arr[i] == arr[i - 1])
                continue;
            // Check if the current element is consecutive to the previous one
            if (arr[i] - arr[i - 1] == 1) {
                count++;
            } else {
                // Update maxCount if a longer consecutive subsequence is found
                maxCount = Math.max(count, maxCount);
                count = 1; // Reset the count for a new sequence
            }
        }

        return Math.max(count, maxCount); // Return the length of the longest consecutive subsequence
    }

    // Method 3: HashSet approach
    // Time Complexity: O(N) on average
    // Space Complexity: O(N) for the HashSet
    public static int findLongestConseqSubseq3(int[] arr, int N) {
        HashSet<Integer> set = new HashSet<>(); // Create a HashSet to store the array elements
        for (int num : arr) {
            set.add(num); // Add all elements to the HashSet
        }

        int maxCount = 0; // To keep track of the maximum length of consecutive subsequence

        // Iterate through the array elements
        for (int i = 0; i < N; i++) {
            // Check if the current element is the start of a new sequence
            if (!set.contains(arr[i] - 1)) {
                int count = 1; // Initialize the count of consecutive elements
                int val = arr[i];
                // Check for the next consecutive elements
                while (set.contains(val + 1)) {
                    count++;
                    val++;
                }
                // Update maxCount if a longer consecutive subsequence is found
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount; // Return the length of the longest consecutive subsequence
    }

    // Main method to test the functionality of the above methods
    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 10, 4, 20, 2}; // Sample array
        int N = arr.length; // Length of the array

        // Find and print the length of the longest consecutive subsequence using Method 1
        int longestSeqLength1 = findLongestConseqSubseq1(arr, N);
        System.out.println("Method 1 - Length of the longest consecutive subsequence: " + longestSeqLength1);

        // Find and print the length of the longest consecutive subsequence using Method 2
        int longestSeqLength2 = findLongestConseqSubseq2(arr, N);
        System.out.println("Method 2 - Length of the longest consecutive subsequence: " + longestSeqLength2);

        // Find and print the length of the longest consecutive subsequence using Method 3
        int longestSeqLength3 = findLongestConseqSubseq3(arr, N);
        System.out.println("Method 3 - Length of the longest consecutive subsequence: " + longestSeqLength3);
    }
}
