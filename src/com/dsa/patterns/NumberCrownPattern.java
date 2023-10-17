package com.dsa.patterns;

import java.util.Scanner;

public class NumberCrownPattern {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("No of test cases: ");
		int t = sc.nextInt();

		while (t-- > 0) {
			System.out.print("Enter N: ");
			int n = sc.nextInt();
			numberCrown(n);
			System.out.println();
		}
		sc.close();
	}

	public static void numberCrown(int n) {
		for (int i = 1; i <= n; i++) {
			// print numbers in increasing order
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}

			// print spaces
			for (int j = 1; j <= (2 * n - 2 * i); j++) {
				System.out.print("  ");
			}

			// print numbers in decreasing order
			for (int j = i; j >= 1; j--) {
				System.out.print(j + " ");
			}

			// print new line
			System.out.println();
		}
	}
	
	/**
	 * 	No of test cases: 2
		Enter N: 6
		1                     1 
		1 2                 2 1 
		1 2 3             3 2 1 
		1 2 3 4         4 3 2 1 
		1 2 3 4 5     5 4 3 2 1 
		1 2 3 4 5 6 6 5 4 3 2 1 
		
		Enter N: 5
		1                 1 
		1 2             2 1 
		1 2 3         3 2 1 
		1 2 3 4     4 3 2 1 
		1 2 3 4 5 5 4 3 2 1 
		
	 */
}
