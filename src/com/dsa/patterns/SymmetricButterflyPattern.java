package com.dsa.patterns;

import java.util.Scanner;

public class SymmetricButterflyPattern {
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

		for (int i = 1; i <= 2 * n - 1; i++) {
			// print stars
			int starEnd = i;
			if (i > n) {
				starEnd = 2 * n - i;
			}
			for (int j = 1; j <= starEnd; j++) {
				System.out.print("* ");
			}

			// print spaces
			int spaceEnd = 2 * (n - i);
			if (i > n) {
				spaceEnd = spaceEnd * -1;
			}
			for (int j = 1; j <= spaceEnd; j++) {
				System.out.print("  ");
			}

			// print stars
			for (int j = 1; j <= starEnd; j++) {
				System.out.print("* ");
			}

			// print new line
			System.out.println();
		}
	}
	
	/**
	 * 	No of test cases: 2
		Enter N: 3
		*         * 
		* *     * * 
		* * * * * * 
		* *     * * 
		*         * 
		
		Enter N: 4
		*             * 
		* *         * * 
		* * *     * * * 
		* * * * * * * * 
		* * *     * * * 
		* *         * * 
		*             * 

	 */
}
