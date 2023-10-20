package com.dsa.mathematical;

/**
 * Given an integer N, write a function that returns the number of trailing
 * zeroes in N! (N factorial).
 */

public class TrailingZeroesInFactorial {

	/**
	 * Method to count the number of trailing zeroes in N! (N factorial).
	 * 
	 * @param N the integer N
	 * @return the number of trailing zeroes in N!
	 */
	static int trailingZeroes(int N) {
		int count = 0;

		// Counting the number of factors of 5 in N!
		for (int i = 5; i <= N; i = i * 5) {
			count += (N / i);
		}

		return count;
	}

	// Main method with test cases
	public static void main(String[] args) {
		// Test cases
		int N1 = 100; // Expected output: 24
		int N2 = 20; // Expected output: 4

		// Testing trailingZeroes method
		System.out.println("Number of trailing zeroes in " + N1 + "!: " + trailingZeroes(N1)); // Expected output: 24
		System.out.println("Number of trailing zeroes in " + N2 + "!: " + trailingZeroes(N2)); // Expected output: 4
	}
}
