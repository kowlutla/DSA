package com.dsa.patterns;

import java.util.Scanner;

public class RightAngleTriangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("No of test cases: ");
		int t = sc.nextInt();

		while (t-- > 0) {
			System.out.print("Enter N: ");
			int n = sc.nextInt();
			printPattern(n);
		}
		sc.close();

	}

	public static void printPattern(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	/*
	 * No of test cases: 2
	Enter N: 4
	* 
	* * 
	* * * 
	* * * * 
	Enter N: 7
	* 
	* * 
	* * * 
	* * * * 
	* * * * * 
	* * * * * * 
	* * * * * * * 

	 */

}
