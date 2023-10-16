package com.dsa.patterns;

import java.util.Scanner;

public class InvertedNumberedRightPyramid {

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
		// Write your code here
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 	No of test cases: 2
		Enter N: 5
		1 2 3 4 5 
		1 2 3 4 
		1 2 3 
		1 2 
		1 
		
		Enter N: 6
		1 2 3 4 5 6 
		1 2 3 4 5 
		1 2 3 4 
		1 2 3 
		1 2 
		1 
		
	 */
}
