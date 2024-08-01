/**
 *  Given a circular integer array arr of size N (i.e ., the next element of arr [N-1] is arr[0] ), return the next greater number for every element in arr.
	The next greater element of a number x is the first greater number to its traversing order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
	 
	
	Example 1:
	
	Input:
	N = 3
	arr[ ] = {1, 2, 1}
	Output: {2, -1, 2}
	Explanation: The first 1's next greater number is 2:
	The number 2 can't find next greater number.
	The second 1's next greater number needs to search circularly, which is also 2.
	Example 2:
	
	Input:
	N = 5
	arr[ ] = {5, 4, 3, 2, 1}
	Output: {-1, 5, 5, 5, 5}
 */
package com.dsa.stack;

import java.util.Stack;

public class ST9NextGreaterElement2 {

    /**
     * Finds the next greater element for each element in a circular array.
     * 
     * Time Complexity: O(N^2) - Nested loops, where the outer loop runs N times
     *                  and the inner loop runs N times in the worst case.
     * Space Complexity: O(N) - Result array of size N.
     *
     * @param N   the number of elements in the array
     * @param arr the input array
     * @return an array where each element is the next greater element in the circular array
     */
    public static int[] nextGreaterElement1(int N, int arr[]) {
        int[] result = new int[N]; // Initialize the result array
        for (int i = 0; i < N; i++) { // Iterate over each element in the array
            int max = -1; // Default value if no greater element is found
            for (int j = i + 1; j < i + N; j++) { // Iterate through the circular array
                if (arr[j % N] > arr[i]) { // Find the next greater element
                    max = arr[j % N];
                    break; // Break once the next greater element is found
                }
            }
            result[i] = max; // Store the next greater element in the result array
        }
        return result; // Return the result array
    }

    /**
     * Finds the next greater element for each element in a circular array using a stack.
     * 
     * Time Complexity: O(N) - Each element is pushed and popped from the stack at most once.
     * Space Complexity: O(N) - Stack and result array of size N.
     *
     * @param nums the input array
     * @return an array where each element is the next greater element in the circular array
     */
    public int[] nextGreaterElements2(int[] nums) {
        Stack<Integer> stack = new Stack<>(); // Initialize the stack to keep track of elements
        int n = nums.length; // Length of the input array
        int[] result = new int[n]; // Initialize the result array
        for (int i = 2 * n - 1; i >= 0; i--) { // Iterate twice over the array (circular)
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) { // Maintain elements in descending order in the stack
                stack.pop(); // Pop elements that are not greater than the current element
            }
            if (i < n) { // Only fill the result array in the first pass
                result[i] = stack.isEmpty() ? -1 : stack.peek(); // Assign the next greater element or -1 if the stack is empty
            }
            stack.push(nums[i % n]); // Push the current element to the stack
        }
        return result; // Return the result array
    }
}
