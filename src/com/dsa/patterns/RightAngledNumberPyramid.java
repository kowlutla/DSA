package com.dsa.patterns;

import java.util.Scanner;

public class RightAngledNumberPyramid {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("No of test cases: ");
		int t = sc.nextInt();

		while (t-- > 0) {
			System.out.print("Enter N: ");
			int n = sc.nextInt();
			nTriangle(n);
			System.out.println();
		}
		sc.close();

	}

	public static void nTriangle(int n) {
		// Write your code here
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	/**
	    No of test cases: 2
		Enter N: 5
		1 
		1 2 
		1 2 3 
		1 2 3 4 
		1 2 3 4 5 
		
		Enter N: 4
		1 
		1 2 
		1 2 3 
		1 2 3 4 
	
	 */

}
