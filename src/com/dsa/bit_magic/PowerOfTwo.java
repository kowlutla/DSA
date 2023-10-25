package com.dsa.bit_magic;

/**
 * Given a non-negative integer N. The task is to check if N is a power of 2.
 * More formally, check if N can be expressed as 2x for some integer x. Return
 * true if N is power of 2 else return false.
 */
public class PowerOfTwo {

	// Function to check if the given number n is a power of two using bitwise
	// operations
	public static boolean isPowerofTwo(long n) {
		// Check if n is 0, if it is, return false
		if (n == 0) {
			return false;
		}
		// Check if n and (n-1) have all bits as 0 except one
		return (n & (n - 1)) == 0;
	}

	// Function to check if the given number n is a power of two using division
	public static boolean isPowerofTwo1(long n) {
		// Check if n is 0, if it is, return false
		if (n == 0) {
			return false;
		}

		// Loop until n becomes 1
		while (n != 1) {
			// If n is not divisible by 2, return false
			if (n % 2 != 0) {
				return false;
			}

			// Divide n by 2
			n = n / 2;
		}

		// Return true if n is a power of two
		return true;
	}

	// Main method to test the isPowerofTwo functionality
	public static void main(String[] args) {
		// Example usage
		long n = 16;
		System.out.println("Using isPowerofTwo: " + isPowerofTwo(n));
		System.out.println("Using isPowerofTwo1: " + isPowerofTwo1(n));
	}
}
