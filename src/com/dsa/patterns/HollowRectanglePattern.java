package com.dsa.patterns;

import java.util.Scanner;

public class HollowRectanglePattern {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("No of test cases: ");
		int t = sc.nextInt();

		while (t-- > 0) {
			System.out.print("Enter N: ");
			int n = sc.nextInt();
			getStarPattern(n);
			System.out.println();
		}
		sc.close();
	}

	public static void getStarPattern(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				// print star on first/last of row/column
				if (i == 1 || j == 1 || i == n || j == n) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	/**
	 *  No of test cases: 2
		Enter N: 5
		*****
		*   *
		*   *
		*   *
		*****
		
		Enter N: 6
		******
		*    *
		*    *
		*    *
		*    *
		******
		

	 */
}
