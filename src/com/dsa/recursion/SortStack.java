/**
 * 	Given a stack, the task is to sort it such that the top of the stack has the greatest element.

	Example 1:
	Input:
	Stack: 3 2 1
	Output: 3 2 1

	Example 2:
	Input:
	Stack: 11 2 32 3 41
	Output: 41 32 11 3 2
 */
package com.dsa.recursion;

import java.util.Stack;

/**
 * @author KowlutlaSwamy
 *
 */

public class SortStack {

    // Method to sort the given stack in ascending order
    public Stack<Integer> sort(Stack<Integer> s) {
        sortRec(s); // Call the recursive sorting method
        return s; // Return the sorted stack
    }

    // Recursive method to sort the stack
    public void sortRec(Stack<Integer> s) {
        // Base case: if the stack is empty, no sorting needed
        if (s.isEmpty()) {
            return;
        }

        // Pop the top element from the stack
        int current = s.pop();
        // Recursively sort the remaining elements in the stack
        sortRec(s);
        // Place the popped element at its correct position in the sorted stack
        placeAtRight(s, current);
    }

    // Helper method to place the given value at its correct position in the stack
    public void placeAtRight(Stack<Integer> s, int value) {
        // If the stack is empty or the top element is less than or equal to the value, push the value
        if (s.isEmpty() || s.peek() <= value) {
            s.push(value);
        } else {
            // If the top element is greater than the value, temporarily pop it, and recursively call to place the value
            int temp = s.pop();
            placeAtRight(s, value);
            // Push back the temporarily popped element after placing the value at its correct position
            s.push(temp);
        }
    }

    // Main method to demonstrate sorting a stack
    public static void main(String[] args) {
        SortStack sorter = new SortStack();
        
        // Create a stack and push some elements
        Stack<Integer> stackToSort = new Stack<>();
        stackToSort.push(34);
        stackToSort.push(3);
        stackToSort.push(31);
        stackToSort.push(98);
        stackToSort.push(92);
        stackToSort.push(23);

        // Print the original stack
        System.out.println("Original Stack: " + stackToSort);

        // Sort the stack using the sort method
        sorter.sort(stackToSort);

        // Print the sorted stack
        System.out.println("Sorted Stack: " + stackToSort);
    }
}
