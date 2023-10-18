package com.dsa.mathematical;

/**
 * Problem: Given a number n print number of digits in number
 */
public class CountDigits {

	public static void main(String[] args) {
		// Test the countDigits method with different inputs
		int number1 = 3456;
		int number2 = 789;
		int number3 = 100;

		// Testing countDigits method
		System.out.println("Number of digits in " + number1 + " (countDigits1): " + countDigits1(number1));
		System.out.println("Number of digits in " + number2 + " (countDigits1): " + countDigits1(number2));
		System.out.println("Number of digits in " + number3 + " (countDigits1): " + countDigits1(number3));

		// Testing countDigits2 method
		System.out.println();
		System.out.println("Number of digits in " + number1 + " (countDigits2): " + countDigits2(number1));
		System.out.println("Number of digits in " + number2 + " (countDigits2): " + countDigits2(number2));
		System.out.println("Number of digits in " + number3 + " (countDigits2): " + countDigits2(number3));
	}

	public static int countDigits1(int n) {
		int result = 0; // Initialize a variable to keep track of the count of digits

		// Iterate until the number becomes 0
		while (n != 0) {
			result++; // Increment the result to count the number of digits
			n /= 10; // Divide the number by 10 to remove the last digit
		}

		return result; // Return the count of digits in the original number
	}

	/**
	 * This method counts the number of digits in a given integer 'n' using a
	 * recursive approach.
	 * 
	 * @param n The integer for which the number of digits is to be counted.
	 * @return The number of digits in the given integer.
	 */
	public static int countDigits2(int n) {
		// If the number is less than 10, it means there is only one digit.
		if (n < 10) {
			return 1;
		}
		// Recursive call with n/10 to count the number of digits in the remaining part
		// of the number.
		return 1 + countDigits2(n / 10);
	}

}
