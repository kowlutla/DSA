/**
 * 	We are given an integer array asteroids of size N representing asteroids in a row. For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
	Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are of same size, both will explode. Two asteroids moving in the same direction will never meet.
	 
	Example 1:
	Input:
	N = 3
	asteroids[ ] = {3, 5, -3}
	Output: {3, 5}
	Explanation: The asteroid 5 and -3 collide resulting in 5. The 5 and 3 never collide.

	Example 2:
	Input:
	N = 2
	asteroids[ ] = {10, -10}
	Output: { }
	Explanation: The asteroid -10 and 10 collide exploding each other.
 */
package com.dsa.stack;

import java.util.Stack;

public class ST13AsteroidCollision {

    /**
     * Simulates the collision of asteroids and returns the state of the asteroids after all collisions.
     * 
     * Time Complexity: O(N) - Each asteroid is processed at most twice (once when pushed onto the stack and
     *                  once when popped from the stack).
     * Space Complexity: O(N) - Uses a stack to store the asteroids.
     *
     * @param N   the number of asteroids
     * @param arr the input array representing the asteroids' sizes and directions
     * @return the array of remaining asteroids after all collisions
     */
    public static int[] asteroidCollision(int N, int[] arr) {
        Stack<Integer> stack = new Stack<>(); // Initialize the stack to keep track of asteroids
        for (int i = 0; i < N; i++) { // Iterate over each asteroid
            if (arr[i] < 0) { // Process a left-moving asteroid
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(arr[i])) {
                    stack.pop(); // Pop smaller right-moving asteroids
                }
                if (!stack.isEmpty() && stack.peek() == Math.abs(arr[i])) {
                    stack.pop(); // Pop right-moving asteroid of the same size
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(arr[i]); // Push the left-moving asteroid if no collision
                }
            } else {
                stack.push(arr[i]); // Push right-moving asteroids directly
            }
        }

        // Prepare the result array from the stack
        int count = stack.size();
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[count - i - 1] = stack.pop(); // Populate result array in reverse order
        }
        return result; // Return the final state of asteroids
    }
}
