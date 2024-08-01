/**
 * Given an array a of integers of length n, find the nearest smaller number for every element such that the smaller element is on left side.If no small element present on the left print -1.
	
	Example 1:
	Input: n = 3
	a = {1, 6, 2}
	Output: -1 1 1
	Explaination: There is no number at the 
	left of 1. Smaller number than 6 and 2 is 1.

	Example 2:
	Input: n = 6
	a = {1, 5, 0, 3, 4, 5}
	Output: -1 1 -1 0 3 4
	Explaination: Upto 3 it is easy to see 
	the smaller numbers. But for 4 the smaller 
	numbers are 1, 0 and 3. But among them 3 
	is closest. Similary for 5 it is 4.
 */
package com.dsa.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ST10PreviousSmallerElement {

    /**
     * Finds the previous smaller element for each element in the array.
     * 
     * Time Complexity: O(N^2) - Nested loops, where the outer loop runs N times
     *                  and the inner loop runs N times in the worst case.
     * Space Complexity: O(N) - Result list of size N.
     *
     * @param n the number of elements in the array
     * @param a the input array
     * @return a list where each element is the previous smaller element in the array
     */
    static List<Integer> leftSmaller1(int n, int a[]) {
        List<Integer> result = new ArrayList<>(); // Initialize the result list
        for (int i = 0; i < n; i++) { // Iterate over each element in the array
            int min = Integer.MAX_VALUE; // Default value if no smaller element is found
            for (int j = i - 1; j >= 0; j--) { // Iterate to the left of the current element
                if (a[j] < a[i]) { // Find the previous smaller element
                    min = a[j];
                    break; // Break once the previous smaller element is found
                }
            }
            if (min == Integer.MAX_VALUE) { // If no smaller element was found
                result.add(-1); // Add -1 to the result
            } else {
                result.add(min); // Add the previous smaller element to the result
            }
        }
        return result; // Return the result list
    }

    /**
     * Finds the previous smaller element for each element in the array using a stack.
     * 
     * Time Complexity: O(N) - Each element is pushed and popped from the stack at most once.
     * Space Complexity: O(N) - Stack and result list of size N.
     *
     * @param n the number of elements in the array
     * @param a the input array
     * @return a list where each element is the previous smaller element in the array
     */
    static List<Integer> leftSmaller2(int n, int a[]) {
        List<Integer> result = new ArrayList<>(); // Initialize the result list
        Stack<Integer> stack = new Stack<>(); // Initialize the stack to keep track of elements
        for (int i = 0; i < n; i++) { // Iterate over each element in the array
            while (!stack.isEmpty() && stack.peek() >= a[i]) { // Maintain elements in ascending order in the stack
                stack.pop(); // Pop elements that are not smaller than the current element
            }
            if (stack.isEmpty()) { // If the stack is empty
                result.add(-1); // Add -1 to the result
            } else {
                result.add(stack.peek()); // Add the previous smaller element to the result
            }
            stack.push(a[i]); // Push the current element to the stack
        }
        return result; // Return the result list
    }
}
