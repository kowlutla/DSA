package com.dsa.bit_magic;

/**
 * Given a number N, swap the two nibbles in it and find the resulting number.
 */
public class SwapTwoNibblesInAByte {
	// Function to swap the two nibbles in a byte
	// and find the resulting number
	static int swapNibbles(int N) {
		return ((N & 0x0F) << 4 | (N & 0xF0) >> 4);
	}

	// Main method to test the swapNibbles function
	public static void main(String[] args) {
		// Test the swapNibbles method with some sample inputs
		int testNumber1 = 0b10011011; // 155 in decimal
		System.out.println("Original Number: " + testNumber1);
		System.out.println("Number after swapping nibbles: " + swapNibbles(testNumber1));

		int testNumber2 = 0b00101100; // 44 in decimal
		System.out.println("Original Number: " + testNumber2);
		System.out.println("Number after swapping nibbles: " + swapNibbles(testNumber2));
	}
}
