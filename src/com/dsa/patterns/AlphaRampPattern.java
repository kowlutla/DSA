package com.dsa.patterns;

import java.util.Scanner;

public class AlphaRampPattern {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("No of test cases: ");
		int t = sc.nextInt();

		while (t-- > 0) {
			System.out.print("Enter N: ");
			int n = sc.nextInt();
			alphaRamp(n);
			System.out.println();
		}
		sc.close();
	}

	public static void alphaRamp(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print((char) ('A' + i - 1) + " ");
			}
			System.out.println();
		}
	}

	/**
	 *  No of test cases: 2
		Enter N: 7
		A 
		B B 
		C C C 
		D D D D 
		E E E E E 
		F F F F F F 
		G G G G G G G 
		
		Enter N: 8
		A 
		B B 
		C C C 
		D D D D 
		E E E E E 
		F F F F F F 
		G G G G G G G 
		H H H H H H H H 
		

	 */
}
