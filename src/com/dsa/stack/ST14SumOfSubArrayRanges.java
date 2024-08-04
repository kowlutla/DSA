/**
 * 	Given an integer array arr of size N. The Range of a subarray of arr is the difference between the largest and smaller element in the subarray.  
	Return the sum of all subarray ranges of arr.
	
	Example 1:
	Input:
	N = 3
	arr[ ] = {1, 2, 3}
	Output: 4
	Explanation: The 6 subarrays of arr are the following :
	{1 } , range = largest - smallest = 1 - 1 = 0 
	{2 } , range = 2 - 2 = 0
	{3 } , range = 3 - 3 = 0
	{1, 2}, range = 2 - 1 = 1
	{2, 3}, range = 3 - 2 = 1
	{1, 2, 3}, range = 3 - 1 = 2
	sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4
	 
	Example 2:
	Input:
	N = 4
	arr[ ] = {-32, 0, -2, 72}
	Output: 318
	 
 */
package com.dsa.stack;

/**
 * @author KowlutlaSwamy
 *
 */
public class ST14SumOfSubArrayRanges {

	public static long subarrayRanges1(int N, int[] arr) {

		long sum = 0;
		for (int i = 0; i < N; i++) {
			int max = arr[i];
			int min = arr[i];
			for (int j = i; j < N; j++) {
				min = Math.min(min, arr[j]);
				max = Math.max(max, arr[j]);
				sum += (max - min);
			}
		}
		return sum;
	}
}
