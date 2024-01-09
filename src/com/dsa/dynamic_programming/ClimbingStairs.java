/**
 * 	You are climbing a staircase. It takes n steps to reach the top.
	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

	Example 1:
	Input: n = 2
	Output: 2
	Explanation: There are two ways to climb to the top.
	1. 1 step + 1 step
	2. 2 steps

	Example 2:
	Input: n = 3
	Output: 3
	Explanation: There are three ways to climb to the top.
	1. 1 step + 1 step + 1 step
	2. 1 step + 2 steps
	3. 2 steps + 1 step
	 
 */
package com.dsa.dynamic_programming;

/**
 * @author KowlutlaSwamy
 *
 */
public class ClimbingStairs {

	// Recursive solution for climbing stairs
	public int climbStairsRecursion(int n) {
		// Base case: when there are 1 or 2 steps
		if (n <= 2) {
			return n; // Return the number of ways to climb for 1 or 2 steps
		}
		// Recursive call: climbing from n-1 and n-2 steps
		return climbStairs(n - 1) + climbStairs(n - 2);
	}

	// Dynamic Programming solution for climbing stairs
	public int climbStairs(int n) {
		// Base case: when there are 1 or 2 steps
		if (n <= 2) {
			return n; // Return the number of ways to climb for 1 or 2 steps
		}
		int dp[] = new int[n + 1]; // DP array to store the number of ways at each step
		dp[1] = 1; // Base case: there is 1 way to climb 1 step
		dp[2] = 2; // Base case: there are 2 ways to climb 2 steps

		// Calculate the number of ways to climb for steps greater than 2
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2]; // Number of ways to reach step i is sum of ways to reach i-1 and i-2
		}
		return dp[n]; // Return the total number of ways to climb n steps
	}
	
	public static void main(String[] args) {
        ClimbingStairs stairs = new ClimbingStairs();
        int n = 6; // Change this value to test different steps
        int waysRecursion = stairs.climbStairsRecursion(n);
        int waysDP = stairs.climbStairs(n);
        
        System.out.println("Using Recursion: Number of ways to climb " + n + " steps is " + waysRecursion);
        System.out.println("Using Dynamic Programming: Number of ways to climb " + n + " steps is " + waysDP);
    }
}
