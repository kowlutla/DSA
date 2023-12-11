/**
 * Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.
 * NOTE*: A subarray is a contiguous part of any given array.
 *
 * Example 1:
 * Input:
 * N = 4, K = 2
 * Arr = [100, 200, 300, 400]
 * Output:
 * 700
 * Explanation:
 * Arr3 + Arr4 = 700,
 * which is maximum.
 *
 * Example 2:
 * Input:
 * N = 4, K = 4
 * Arr = [100, 200, 300, 400]
 * Output:
 * 1000
 * Explanation:
 * Arr1 + Arr2 + Arr3 + Arr4 = 1000,
 * which is maximum.
 *
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function maximumSumSubarray()
 * which takes the integer K, vector Arr with size N, containing the elements of the array and returns
 * the maximum sum of a subarray of size K.
 *
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(1)
 *
 * Constraints:
 * 1 <= N <= 10^5
 * 1 <= Arr[i] <= 10^5
 * 1 <= K <= N
 */

package com.dsa.arrays;

import java.util.ArrayList;

/**
 * Author: KowlutlaSwamy
 */
public class MaxSumSubarrayOfSizeK {
	static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
		
		long sum = 0, result = 0;
		
		// Calculate the sum of the first K elements
		for (int i = 0; i < K; i++) {
			sum += Arr.get(i);
		}
		result = sum; // Initialize result with the sum of the first K elements
		
		// Calculate the sum of subsequent subarrays of size K and find the maximum sum
		for (int i = K; i < N; i++) {
			sum = sum - Arr.get(i - K) + Arr.get(i); // Update the sum by excluding the first element and including the
			                                         // current element
			result = Math.max(result, sum); // Update the result with the maximum sum found so far
		}
		
		return result; // Return the maximum sum of a subarray of size K
		
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(100);
		arr.add(200);
		arr.add(300);
		arr.add(400);
		
		int K1 = 2;
		int K2 = 4;
		
		// Calculate the maximum sum of subarrays of size K
		long result1 = maximumSumSubarray(K1, arr, arr.size());
		long result2 = maximumSumSubarray(K2, arr, arr.size());
		
		// Display the results
		System.out.println("For K = 2, Maximum Sum: " + result1);
		System.out.println("For K = 4, Maximum Sum: " + result2);
		
	}
}
