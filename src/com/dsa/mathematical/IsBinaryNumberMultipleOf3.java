package com.dsa.mathematical;

/**
 * Given a number in its binary form find if the given binary number is a
 * multiple of 3. It is recommended to finish the task using one traversal of
 * input binary number.
 */
public class IsBinaryNumberMultipleOf3 {

	/**
     * Checks if the binary number is divisible by 3.
     * 
     * @param s the binary string
     * @return 1 if the binary number is divisible by 3, 0 otherwise
     */
	int isDivisible(String s) {

		// Initializing counts for even and odd positions
		int evenCount = 0;
		int oddCount = 0;

		// Iterating through the binary string
		for (int i = s.length() - 1; i >= 0; i--) {
			if (i % 2 == 0) {
				evenCount += s.charAt(i) - '0'; // Counting set bits at even positions
			} else {
				oddCount += s.charAt(i) - '0'; // Counting set bits at odd positions
			}
		}

		// Checking if the absolute difference between the counts is divisible by 3
		return (Math.abs(evenCount - oddCount)) % 3 == 0 ? 1 : 0;
	}

	// Main method with test cases
	public static void main(String[] args) {
		IsBinaryNumberMultipleOf3 obj = new IsBinaryNumberMultipleOf3();

		// Test cases
		String S1 = "0011"; // Expected output: 1
		String S2 = "100"; // Expected output: 0

		// Testing isDivisible method
		System.out.println("Is " + S1 + " divisible by 3? " + (obj.isDivisible(S1) == 1 ? "Yes" : "No")); // Expected output: 1
		System.out.println("Is " + S2 + " divisible by 3? " + (obj.isDivisible(S2) == 1 ? "Yes" : "No")); // Expected output: 0
	}
}
