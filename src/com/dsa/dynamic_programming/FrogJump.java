/**
 * Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair. 
 * At a time the frog can climb either one or two steps. A height[N] array is also given. 
 * Whenever the frog jumps from a stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), 
 * where abs() means the absolute difference. We need to return the minimum energy that can be used by the frog to 
 * jump from stair 0 to stair N-1.
 * 
 * 
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class FrogJump {

	// Space optimization approach
	public static int frogJumpSpaceOptimization(int n, int heights[]) {
		// Variables to track the minimum jumps considering two previous positions
		int prev1 = 0;
		int prev2 = 0;

		for (int i = 1; i < n; i++) {
			// Calculate jump from current position to the previous one
			int jump1 = prev1 + Math.abs(heights[i] - heights[i - 1]);
			// Initialize jump2 as maximum value initially
			int jump2 = Integer.MAX_VALUE;
			// Calculate jump from current position to two positions back (if available)
			if (i > 1) {
				jump2 = prev2 + Math.abs(heights[i] - heights[i - 2]);
			}

			// Determine the minimum of the two jumps
			int current = Math.min(jump1, jump2);
			// Update previous positions for the next iteration
			prev2 = prev1;
			prev1 = current;
		}
		return prev1; // Return the minimum jumps to reach the end
	}

	// Using tabulation
	public static int frogJumpTabulation(int n, int heights[]) {
		// Create an array to store minimum jumps required at each position
		int[] dp = new int[n];
		dp[0] = 0; // Initial position requires 0 jumps

		for (int i = 1; i < n; i++) {
			// Calculate jump from current position to the previous one
			int jump1 = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
			// Initialize jump2 as maximum value initially
			int jump2 = Integer.MAX_VALUE;
			// Calculate jump from current position to two positions back (if available)
			if (i > 1) {
				jump2 = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
			}

			// Store the minimum of the two jumps at the current position
			dp[i] = Math.min(jump1, jump2);
		}
		return dp[n - 1]; // Return the minimum jumps to reach the end
	}

	// Using memorization
	public static int frogJumpMemorization(int index, int heights[], int[] dp) {
		// Base case: if we're at the starting position, return 0
		if (index == 0) {
			return 0;
		}

		// If the minimum jumps for this position is already calculated, return it
		if (dp[index] != -1) {
			return dp[index];
		}

		// Calculate the jumps from current position to previous positions
		int jump1 = frogJumpMemorization(index - 1, heights, dp)
				+ Math.abs(heights[index] - heights[index - 1]);
		int jump2 = Integer.MAX_VALUE;
		if (index > 1) {
			jump2 = frogJumpMemorization(index - 2, heights, dp)
					+ Math.abs(heights[index] - heights[index - 2]);
		}

		// Store the minimum of the two jumps for this position in the dp array
		return dp[index] = Math.min(jump2, jump1);
	}

	// Using recursion
	public static int frogJumpRecursion(int index, int heights[]) {
		// Base case: if we're at the starting position, return 0
		if (index == 0) {
			return 0;
		}

		// Calculate the jumps from current position to previous positions
		int jump1 = frogJumpRecursion(index - 1, heights)
				+ Math.abs(heights[index] - heights[index - 1]);
		int jump2 = Integer.MAX_VALUE;
		if (index > 1) {
			jump2 = frogJumpRecursion(index - 2, heights)
					+ Math.abs(heights[index] - heights[index - 2]);
		}

		// Return the minimum of the two jumps for this position
		return Math.min(jump2, jump1);
	}

	public static void main(String[] args) {
		// Test your methods here with sample input
		int[] heights = { 10, 30, 40, 20 };
		int n = heights.length;

		System.out.println("Space Optimization: " + frogJumpSpaceOptimization(n, heights));
		System.out.println("Tabulation: " + frogJumpTabulation(n, heights));

		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		System.out.println("Memorization: " + frogJumpMemorization(n-1, heights, dp));
		

		System.out.println("Recursion: " + frogJumpRecursion(n - 1, heights));
	}
}
