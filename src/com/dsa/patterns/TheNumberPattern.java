package com.dsa.patterns;

import java.util.Scanner;

public class TheNumberPattern {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("No of test cases: ");
		int t = sc.nextInt();

		while (t-- > 0) {
			System.out.print("Enter N: ");
			int n = sc.nextInt();
			getNumberPattern(n);
			System.out.println();
		}
		sc.close();
	}

	public static void getNumberPattern(int n) {
		for (int i = 1; i < 2 * n; i++) {
			for (int j = 1; j < 2 * n; j++) {
				// get the distance from top,bottom,left and right for current position
				int top = i - 1;
				int bottom = 2 * n - 1 - i;
				int left = j - 1;
				int right = 2 * n - 1 - j;

				int value = n - Math.min(Math.min(top, bottom), Math.min(left, right));
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 	No of test cases: 2
		Enter N: 4
		4 4 4 4 4 4 4 
		4 3 3 3 3 3 4 
		4 3 2 2 2 3 4 
		4 3 2 1 2 3 4 
		4 3 2 2 2 3 4 
		4 3 3 3 3 3 4 
		4 4 4 4 4 4 4 
		
		Enter N: 5
		5 5 5 5 5 5 5 5 5 
		5 4 4 4 4 4 4 4 5 
		5 4 3 3 3 3 3 4 5 
		5 4 3 2 2 2 3 4 5 
		5 4 3 2 1 2 3 4 5 
		5 4 3 2 2 2 3 4 5 
		5 4 3 3 3 3 3 4 5 
		5 4 4 4 4 4 4 4 5 
		5 5 5 5 5 5 5 5 5 
		
	 */
}
