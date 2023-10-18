package com.dsa.mathematical;

/**
 * Given a number n, find number of digits of 'n' that evenly divides n
 */

public class CountDigits1 {

	/**
	 * This method counts the number of non-zero digits in an integer 'n' that are
	 * factors of 'n' itself.
	 * 
	 * @param n The integer for which the digits are to be counted.
	 * @return The number of digits satisfying the condition.
	 */
	public static int countDigits(int n) {
		int count = 0; // Initialize a variable to count the desired digits
		int temp = n; // Store the original value of n in a temporary variable

		// Iterate through each digit of the number
		while (n > 0) {
			int digit = n % 10; // Extract the last digit of the number

			// Check if the digit is not zero and if it is a factor of the original number
			if (digit != 0 && temp % digit == 0) {
				count++; // Increment the count if the condition is satisfied
			}

			n /= 10; // Remove the last digit from the number
		}

		return count; // Return the final count of desired digits
	}

	/**
	 * The main method for testing the countDigits method.
	 */
	public static void main(String[] args) {
		// Test the countDigits method with different inputs
		int number1 = 3456;
		int number2 = 789;
		int number3 = 100;

		// Testing countDigits method
		System.out.println("Number of digits satisfying the condition in " + number1 + ": " + countDigits(number1));
		System.out.println("Number of digits satisfying the condition in " + number2 + ": " + countDigits(number2));
		System.out.println("Number of digits satisfying the condition in " + number3 + ": " + countDigits(number3));
	}

	/**
	 * 	Number of digits satisfying the condition in 3456: 3
		Number of digits satisfying the condition in 789: 0
		Number of digits satisfying the condition in 100: 1

	 */
}
