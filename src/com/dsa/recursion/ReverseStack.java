/**
 *	You are given a stack St. You have to reverse the stack using recursion.

	Example 1:
	
	Input:
	St = {3,2,1,7,6}
	Output:
	{6,7,1,2,3}
	Explanation:
	Input stack after reversing will look like the stack in the output.
	Example 2:
	
	Input:
	St = {4,3,9,6}
	Output:
	{6,9,3,4}
	Explanation:
	Input stack after reversing will look like the stack in the output. 
 */
package com.dsa.recursion;

import java.util.Stack;

public class ReverseStack {

    // Method to reverse the given stack
    public static void reverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return; // If the stack is empty, nothing to reverse
        }

        // Pop the top element from the stack
        int current = s.pop();
        // Recursively reverse the remaining elements in the stack
        reverse(s);
        // Insert the popped element at the bottom of the reversed stack
        insertAtBottom(s, current);
    }

    // Helper method to insert the given value at the bottom of the stack
    private static void insertAtBottom(Stack<Integer> s, int value) {
        // If the stack is empty, push the value
        if (s.isEmpty()) {
            s.push(value);
        } else {
            // If the stack is not empty, temporarily pop the top element,
            // recursively call to insert the value at the bottom, and then push back the temporarily popped element
            int temp = s.pop();
            insertAtBottom(s, value);
            s.push(temp);
        }
    }

    // Main method to demonstrate reversing a stack
    public static void main(String[] args) {
        Stack<Integer> stackToReverse = new Stack<>();
        stackToReverse.push(1);
        stackToReverse.push(2);
        stackToReverse.push(3);
        stackToReverse.push(4);
        stackToReverse.push(5);

        // Print the original stack
        System.out.println("Original Stack: " + stackToReverse);

        // Reverse the stack using the reverse method
        reverse(stackToReverse);

        // Print the reversed stack
        System.out.println("Reversed Stack: " + stackToReverse);
    }
}
