/**
 * Given an array arr of size N containing positive integers, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since answer may be very large, return the answer modulo 109 +7. 
	
	Example 1:
	Input:
	N = 4
	arr[ ] = {3, 1, 2, 4}
	Output: 17
	Explanation: subarrays are {3}, {1}, {2}, {4}, {3, 1}, {1, 2}, {2, 4}, {3, 1, 2}, {1, 2, 4}, {3, 1, 2, 4}.
	Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1. Sum is 17.
	 
	 
	
	Example 2:
	Input:
	N = 4
	arr[ ] = {71, 55, 82, 55}
	Output: 593
 */
package com.dsa.stack;

import java.util.Stack;

public class ST12SumOfSubarrayMinimum {

    /**
     * Calculates the sum of the minimum values of all subarrays using a brute force approach.
     * 
     * Time Complexity: O(N^2) - Nested loops, where the outer loop runs N times
     *                  and the inner loop runs N times in the worst case.
     * Space Complexity: O(1) - Uses a constant amount of extra space.
     *
     * @param N   the number of elements in the array
     * @param arr the input array
     * @return the sum of the minimum values of all subarrays
     */
    public static int sumSubarrayMins1(int N, int[] arr) {
        int mod = (int) Math.pow(10, 9) + 7; // Modulo value to prevent overflow

        int result = 0;
        for (int i = 0; i < N; i++) { // Iterate over each starting element of the subarrays
            int min = arr[i];
            for (int j = i; j < N; j++) { // Iterate over each ending element of the subarrays
                min = Math.min(min, arr[j]); // Find the minimum element in the current subarray
                result = (result + min) % mod; // Add the minimum to the result
            }
        }
        return result; // Return the total sum of minimum values
    }

    /**
     * Calculates the sum of the minimum values of all subarrays using a more efficient approach.
     * 
     * Time Complexity: O(N) - Each element is processed in linear time.
     * Space Complexity: O(N) - Uses extra space for arrays and stack of size N.
     *
     * @param N   the number of elements in the array
     * @param arr the input array
     * @return the sum of the minimum values of all subarrays
     */
    public static int sumSubarrayMins2(int N, int[] arr) {
        int mod = (int) Math.pow(10, 9) + 7; // Modulo value to prevent overflow

        int[] nextSmall = getNextSmallest(arr); // Get indices of the next smaller element for each element
        int[] prevSmall = getPrevSmallest(arr); // Get indices of the previous smaller element for each element

        int result = 0;
        for (int i = 0; i < N; i++) {
            int left = i - prevSmall[i]; // Number of subarrays ending at index i
            int right = nextSmall[i] - i; // Number of subarrays starting at index i
            result = (result + ((left * right * arr[i]) % mod)) % mod; // Calculate the contribution of arr[i] to the result
        }
        return result; // Return the total sum of minimum values
    }

    /**
     * Finds the indices of the next smaller elements for each element in the array.
     * 
     * @param arr the input array
     * @return an array of indices of the next smaller elements
     */
    private static int[] getNextSmallest(int[] arr) {
        Stack<Integer> stack = new Stack<>(); // Initialize the stack to keep track of indices
        int n = arr.length;
        int[] result = new int[n]; // Initialize the result array
        for (int i = n - 1; i >= 0; i--) { // Iterate over the array from right to left
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) { // Maintain elements in ascending order in the stack
                stack.pop(); // Pop elements that are not smaller than the current element
            }
            result[i] = stack.isEmpty() ? n : stack.peek(); // Store the index of the next smaller element or n if none exists
            stack.push(i); // Push the current index to the stack
        }
        return result; // Return the result array
    }

    /**
     * Finds the indices of the previous smaller elements for each element in the array.
     * 
     * @param arr the input array
     * @return an array of indices of the previous smaller elements
     */
    private static int[] getPrevSmallest(int[] arr) {
        Stack<Integer> stack = new Stack<>(); // Initialize the stack to keep track of indices
        int n = arr.length;
        int[] result = new int[n]; // Initialize the result array
        for (int i = 0; i < n; i++) { // Iterate over the array from left to right
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) { // Maintain elements in ascending order in the stack
                stack.pop(); // Pop elements that are not smaller than the current element
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek(); // Store the index of the previous smaller element or -1 if none exists
            stack.push(i); // Push the current index to the stack
        }
        return result; // Return the result array
    }
}
