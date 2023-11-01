package com.dsa.recursion;

/**
 * You are given two numbers n and p. You need to find np.
 */
public class PowerUsingRecursion {
	
	// Method to find the power of a number using recursion
	static int RecursivePower(int n, int p) {
		// Base case: if power is 0, return 1
		if (p == 0) {
			return 1;
		}

		// Recursively calculate the power
		return n * RecursivePower(n, p - 1);
	}
	
	// Main method for testing RecursivePower method
	public static void main(String[] args) {
		// Example input
		int n = 3;
		int p = 4;
		
		// Compute the power of n^p using RecursivePower method
		int result = RecursivePower(n, p);
		
		// Print the result
		System.out.println(n + " raised to the power of " + p + " is: " + result);
	}
}
