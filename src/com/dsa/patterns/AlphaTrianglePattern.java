package com.dsa.patterns;

import java.util.Scanner;

public class AlphaTrianglePattern {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("No of test cases: ");
		int t = sc.nextInt();

		while (t-- > 0) {
			System.out.print("Enter N: ");
			int n = sc.nextInt();
			alphaTriangle(n);
			System.out.println();
		}
		sc.close();
	}

	public static void alphaTriangle(int n) {
		// char last = (char)('A'+n-1);
		for (int i = 1; i <= n; i++) {
			// get the last alphabet character in each row
			char c = (char) ('A' + n - 1);
			for (int j = 1; j <= i; j++, c--) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 	No of test cases: 2
		Enter N: 5
		E 
		E D 
		E D C 
		E D C B 
		E D C B A 
		
		Enter N: 6
		F 
		F E 
		F E D 
		F E D C 
		F E D C B 
		F E D C B A 


	 */

}
