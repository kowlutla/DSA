/**
 * 	Dilpreet wants to paint his dog's home that has n boards with different lengths. The length of ith board is given by arr[i] where arr[] is an array of n integers. He hired k painters for this work and each painter takes 1 unit time to paint 1 unit of the board. 
	The problem is to find the minimum time to get this job done if all painters start together with the constraint that any painter will only paint continuous boards, say boards numbered {2,3,4} or only board {1} or nothing but not boards {2,4,5}.
	
	Example 1:
	
	Input:
	n = 5
	k = 3
	arr[] = {5,10,30,20,15}
	Output: 35
	Explanation: The most optimal way will be:
	Painter 1 allocation : {5,10}
	Painter 2 allocation : {30}
	Painter 3 allocation : {20,15}
	Job will be done when all painters finish
	i.e. at time = max(5+10, 30, 20+15) = 35
	Example 2:
	
	Input:
	n = 4
	k = 2
	arr[] = {10,20,30,40}
	Output: 60
	Explanation: The most optimal way to paint:
	Painter 1 allocation : {10,20,30}
	Painter 2 allocation : {40}
	Job will be complete at time = 60
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class PaintersPartitionProblem {

    // Method to find the minimum time needed for painting (less efficient approach)
    static long minTime1(int[] arr, int n, int k) {
        long min = 0, max = 0;
        // Calculate the minimum and maximum possible times required to paint all boards
        for (int num : arr) {
            min = Math.max(min, num); // Find the maximum time required for a single board
            max += num; // Calculate the total time required for all boards
        }

        // Try different time values and find the one that satisfies the condition
        for (long i = min; i <= max; i++) {
            int painters = getPainters(arr, i); // Get the number of painters for the current time
            if (painters <= k) {
                return i; // If the number of painters required is less than or equal to k, return the time
            }
        }
        return -1; // If no valid time found, return -1
    }

    // Method to find the minimum time needed for painting (more efficient approach using binary search)
    static long minTime(int[] arr, int n, int k) {
        long min = 0, max = 0;
        // Calculate the minimum and maximum possible times required to paint all boards
        for (int num : arr) {
            min = Math.max(min, num); // Find the maximum time required for a single board
            max += num; // Calculate the total time required for all boards
        }

        // Binary search for the minimum time that satisfies the condition
        long low = min, high = max;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            int painters = getPainters(arr, mid); // Get the number of painters for the current time
            if (painters <= k) {
                high = mid - 1; // Reduce the time for the next iteration
            } else {
                low = mid + 1; // Increase the time for the next iteration
            }
        }
        return low; // Return the minimum time that satisfies the condition
    }

    // Helper method to find the number of painters required for a given maximum board painting time
    private static int getPainters(int[] arr, long maxTime) {
        int painters = 1;
        long currentTime = 0;
        for (int i = 0; i < arr.length; i++) {
            if (currentTime + arr[i] <= maxTime) {
                currentTime += arr[i];
            } else {
                painters++;
                currentTime = arr[i];
            }
        }
        return painters; // Return the number of painters needed for the given maximum board painting time
    }
    
    public static void main(String[] args) {
		int[] boardsTime = {10, 20, 30, 40, 25, 61 }; // Sample array representing time required for painting each board
        int totalBoards = boardsTime.length;
        int painters = 3; // Number of painters

        // Using the less efficient approach
        long result1 = minTime1(boardsTime, totalBoards, painters);
        System.out.println("Using minTime1 method: " + result1);

        // Using the more efficient approach (binary search)
        long result2 = minTime(boardsTime, totalBoards, painters);
        System.out.println("Using minTime method: " + result2);
    }
}
