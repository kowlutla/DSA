package com.dsa.mathematical;

public class ReverseNumber {
	/**
	 * This method reverses the digits of a given integer 'n' using an iterative
	 * approach.
	 * 
	 * @param n The integer to be reversed.
	 * @return The reversed integer.
	 */
	public static int reverse1(int n) {
		int result = 0; // Initialize the variable to store the reversed number

		// Iterate until the number becomes 0
		while (n != 0) {
			result = result * 10 + n % 10; // Form the reversed number by extracting digits
			n /= 10; // Remove the last digit from the number
		}
		return result; // Return the reversed number
	}

	// Static variable for storing the reversed number in the recursive method
	static int reverse = 0;

	/**
	 * This method reverses the digits of a given integer 'n' using a recursive
	 * approach.
	 * 
	 * @param n The integer to be reversed.
	 * @return The reversed integer.
	 */
	public static int reverse2(int n) {
		// Base case for recursion when the number becomes 0
		if (n == 0) {
			return reverse;
		}

		// Recursive case for positive numbers
		if (n > 0) {
			int digit = n % 10; // Extract the last digit
			reverse = reverse * 10 + digit; // Form the reversed number
			reverse2(n / 10); // Recursive call with the remaining part of the number
		}
		return reverse; // Return the reversed number
	}

	/**
	 * The main method for testing the reverse methods.
	 */
	public static void main(String[] args) {
		// Test the reverse1 method with different inputs
		int number1 = 12345;
		int number2 = 98765;
		int number3 = 100;

		// Testing reverse1 method
		System.out.println("Reverse of " + number1 + " (reverse1): " + reverse1(number1));
		System.out.println("Reverse of " + number2 + " (reverse1): " + reverse1(number2));
		System.out.println("Reverse of " + number3 + " (reverse1): " + reverse1(number3));

		// Expected output for the provided test cases:
		// Reverse of 12345 (reverse1): 54321
		// Reverse of 98765 (reverse1): 56789
		// Reverse of 100 (reverse1): 1
	}
}
