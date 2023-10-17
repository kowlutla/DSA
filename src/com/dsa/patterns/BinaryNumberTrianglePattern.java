package com.dsa.patterns;

import java.util.Scanner;

public class BinaryNumberTrianglePattern {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("No of test cases: ");
		int t = sc.nextInt();

		while (t-- > 0) {
			System.out.print("Enter N: ");
			int n = sc.nextInt();
			nBinaryTriangle(n);
			System.out.println();
		}
		sc.close();
	}

	public static void nBinaryTriangle(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print((i + j + 1) % 2 + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 	No of test cases: 2
		Enter N: 3
		1 
		0 1 
		1 0 1 
		
		Enter N: 6
		1 
		0 1 
		1 0 1 
		0 1 0 1 
		1 0 1 0 1 
		0 1 0 1 0 1 
		
	 */

}
