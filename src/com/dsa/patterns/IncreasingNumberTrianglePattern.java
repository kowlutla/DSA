package com.dsa.patterns;

import java.util.Scanner;

public class IncreasingNumberTrianglePattern {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("No of test cases: ");
		int t = sc.nextInt();

		while (t-- > 0) {
			System.out.print("Enter N: ");
			int n = sc.nextInt();
			nNumberTriangle(n);
			System.out.println();
		}
		sc.close();
	}

	public static void nNumberTriangle(int n) {
		int count = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(count++ + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 	No of test cases: 2
		Enter N: 7
		1 
		2 3 
		4 5 6 
		7 8 9 10 
		11 12 13 14 15 
		16 17 18 19 20 21 
		22 23 24 25 26 27 28 
		
		Enter N: 4
		1 
		2 3 
		4 5 6 
		7 8 9 10 

	 */
}
