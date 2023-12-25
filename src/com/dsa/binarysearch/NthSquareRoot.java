/**
	Problem Statement: Given two numbers N and M, find the Nth root of M. The nth root of a number M is defined as a number X when raised to the power N equals M. If the ‘nth root is not an integer, return -1.
 * 
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class NthSquareRoot {

	// Main method to test the NthRoot function
	public static void main(String[] args) {
		int n = 3; // Exponent
		int m = 27; // Number to find the nth root of
		int result = NthRoot(n, m);
		System.out.println(
				"Nth root of " + m + " with exponent " + n + " is: " + result); // Expected
																				// Output:
																				// 3
	}

	// Method to find the Nth root of a number
	public static int NthRoot(int n, int m) {
		long low = 1, high = m;

		// Perform binary search to find the Nth root
		while (low <= high) {
			long mid = low + (high - low) / 2;
			long point = getPower(mid, n, m);
			if (point == 0) {
				return (int) mid; // If the Nth root is found, return mid
			} else if (point < 0) {
				low = mid + 1; // If point is negative, move low pointer ahead
			} else {
				high = mid - 1; // If point is positive, move high pointer
								// behind
			}
		}

		return -1; // If Nth root is not found
	}

	// Method to calculate power and compare it with given number
	private static long getPower(long base, long pow, long m) {
		long ans = 1;

		// Calculate the power of 'base' raised to 'pow'
		for (int i = 1; i <= pow; i++) {
			ans = ans * base;
			if (ans > m) {
				return 1; // If the result exceeds 'm', return 1
			}
		}

		if (ans == m) {
			return 0; // If the result is equal to 'm', return 0
		}

		return -1; // If the result is less than 'm', return -1
	}
}
