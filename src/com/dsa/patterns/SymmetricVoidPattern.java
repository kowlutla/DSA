package com.dsa.patterns;

import java.util.Scanner;

public class SymmetricVoidPattern {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("No of test cases: ");
		int t = sc.nextInt();

		while (t-- > 0) {
			System.out.print("Enter N: ");
			int n = sc.nextInt();
			symmetry(n);
			System.out.println();
		}
		sc.close();
	}

	public static void symmetry(int n) {
		// print upper part
		for (int i = 1; i <= n; i++) {
			// print stars
			for (int j = 1; j <= n - i + 1; j++) {
				System.out.print("* ");
			}

			// print spaces
			for (int j = 1; j <= (2 * i - 2); j++) {
				System.out.print("  ");
			}

			// print stars
			for (int j = 1; j <= n - i + 1; j++) {
				System.out.print("* ");
			}
			// print new line
			System.out.println();
		}

		// print lower part
		for (int i = 1; i <= n; i++) {
			// print stars
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}

			// print spaces
			for (int j = 1; j <= (2 * (n - i)); j++) {
				System.out.print("  ");
			}
			// print stars
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}

			// print new line
			System.out.println();
		}
	}
	
	/**
	 *  No of test cases: 2
		Enter N: 5
		* * * * * * * * * * 
		* * * *     * * * * 
		* * *         * * * 
		* *             * * 
		*                 * 
		*                 * 
		* *             * * 
		* * *         * * * 
		* * * *     * * * * 
		* * * * * * * * * * 
		
		Enter N: 6
		* * * * * * * * * * * * 
		* * * * *     * * * * * 
		* * * *         * * * * 
		* * *             * * * 
		* *                 * * 
		*                     * 
		*                     * 
		* *                 * * 
		* * *             * * * 
		* * * *         * * * * 
		* * * * *     * * * * * 
		* * * * * * * * * * * * 
		

	 */
}
