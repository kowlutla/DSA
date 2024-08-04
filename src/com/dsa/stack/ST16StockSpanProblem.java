/**
 *	The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stocks price for all n days. 
	The span Si of the stocks price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the given day is less than or equal to its price on the current day.
	For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.
	
	Example 1:
	Input: 
	N = 7, price[] = [100 80 60 70 60 75 85]
	Output:
	1 1 1 2 1 4 6
	Explanation:
	Traversing the given input span 
	100 is greater than equal to 100 and there are no more elements behind it so the span is 1,
	80 is greater than equal to 80 and smaller than 100 so the span is 1,
	60 is greater than equal to 60 and smaller than 80 so the span is 1,
	70 is greater than equal to 60,70 and smaller than 80 so the span is 2,
	60 is greater than equal to 60 and smaller than 70 so the span is 1,
	75 is greater than equal to 60,70,60,75 and smaller than 100 so the span is 4,
	85 is greater than equal to 80,60,70,60,75,85 and smaller than 100 so the span is 6. 
	Hence the output will be 1 1 1 2 1 4 6.

	Example 2:
	Input: 
	N = 6, price[] = [10 4 5 90 120 80]
	Output:
	1 1 2 4 5 1
	Explanation:
	Traversing the given input span 
	10 is greater than equal to 10 and there are no more elements behind it so the span is 1,
	4 is greater than equal to 4 and smaller than 10 so the span is 1,
	5 is greater than equal to 4,5 and smaller than 10 so the span is 2,
	90 is greater than equal to all previous elements so the span is 4,
	120 is greater than equal to all previous elements so the span is 5,
	80 is greater than equal to 80 and smaller than 120 so the span is 1,
	Hence the output will be 1 1 2 4 5 1. 
 */
package com.dsa.stack;

import java.util.Stack;

public class ST16StockSpanProblem {

    /**
     * Calculates the stock span for each day using a brute force approach.
     * 
     * Time Complexity: O(N^2) - Nested loops, where the outer loop runs N times
     *                  and the inner loop runs N times in the worst case.
     * Space Complexity: O(N) - Uses an array to store the result.
     *
     * @param price the array of stock prices
     * @param n     the number of days
     * @return the array of stock spans for each day
     */
    public static int[] calculateSpan1(int[] price, int n) {
        int[] result = new int[n]; // Initialize the result array
        for (int i = 0; i < n; i++) { // Iterate over each day
            int minIndex = i; // Initialize the minimum index
            for (int j = i; j >= 0; j--) { // Iterate backwards to find the span
                if (price[j] > price[i]) {
                    break; // Break if a higher price is found
                }
                minIndex--;
            }
            result[i] = i - minIndex; // Calculate the span for the current day
        }
        return result; // Return the result array
    }

    /**
     * Calculates the stock span for each day using a stack for efficient processing.
     * 
     * Time Complexity: O(N) - Each element is pushed and popped from the stack at most once.
     * Space Complexity: O(N) - Uses a stack to store indices and an array to store the result.
     *
     * @param price the array of stock prices
     * @param n     the number of days
     * @return the array of stock spans for each day
     */
    public static int[] calculateSpan2(int[] price, int n) {
        int[] result = new int[n]; // Initialize the result array
        Stack<Integer> stack = new Stack<>(); // Initialize the stack to keep track of indices
        for (int i = 0; i < n; i++) { // Iterate over each day
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop(); // Pop elements from the stack while the current price is higher
            }
            if (stack.isEmpty()) {
                result[i] = i + 1; // If the stack is empty, the span is the current index + 1
            } else {
                result[i] = i - stack.peek(); // Calculate the span using the top element of the stack
            }
            stack.push(i); // Push the current index to the stack
        }
        return result; // Return the result array
    }
}
