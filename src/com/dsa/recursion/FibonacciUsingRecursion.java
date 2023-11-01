package com.dsa.recursion;

/**
 * You are given a number n. You need to find nth Fibonacci number.
 * F(n) = F(n-1) + F(n-2); where F(1) = 1 and F(2) = 1
 */
public class FibonacciUsingRecursion {

	// Method to find the nth Fibonacci number using recursion
	static int fibonacci(int n) {
		// Base case: if n is 0 or 1, return n
		if (n == 0 || n == 1) {
			return n;
		}
		// Recursively calculate the Fibonacci number
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	// Main method for testing the Fibonacci method
	public static void main(String[] args) {
		// Example input
		int n = 6;
		
		// Compute the nth Fibonacci number using the fibonacci method
		int result = fibonacci(n);
		
		// Print the result
		System.out.println("The " + n + "th Fibonacci number is: " + result);
	}
}
