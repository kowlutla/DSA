package com.dsa.patterns;

import java.util.Scanner;

public class InvertedStarPyramid {
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

		for (int i = 1; i <= n; i++) {
			// print spaces
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}

			// print stars
			for (int j = 1; j <= (2 * n - (2 * i - 1)); j++) {
				System.out.print("*");
			}

			// print spaces
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}

			System.out.println();
		}
	}
	
	/**
	 * 	No of test cases: 2
		Enter N: 5
		*********
		 ******* 
		  *****  
		   ***   
		    *    
		
		Enter N: 6
		***********
		 ********* 
		  *******  
		   *****   
		    ***    
		     *     
		
	 */
}
