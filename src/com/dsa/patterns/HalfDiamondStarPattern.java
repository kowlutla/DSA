package com.dsa.patterns;

import java.util.Scanner;

public class HalfDiamondStarPattern {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("No of test cases: ");
		int t = sc.nextInt();

		while (t-- > 0) {
			System.out.print("Enter N: ");
			int n = sc.nextInt();
			nStarTriangle(n);
			System.out.println();
		}
		sc.close();
	}

	public static void nStarTriangle(int n) {
		for (int i = 1; i < 2 * n; i++) {
			int end = i;
			// if row is after symmetric
			if (i > n) {
				end = 2 * n - i;
			}
			for (int j = 1; j <= end; j++) {
				System.out.print("*");
			}

			System.out.println();
		}
	}
	
	/**
	 * 	No of test cases: 2
		Enter N: 5
		*
		**
		***
		****
		*****
		****
		***
		**
		*
		
		Enter N: 4
		*
		**
		***
		****
		***
		**
		*


	 */
}
