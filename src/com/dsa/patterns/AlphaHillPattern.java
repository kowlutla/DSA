package com.dsa.patterns;

import java.util.Scanner;

public class AlphaHillPattern {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("No of test cases: ");
		int t = sc.nextInt();

		while (t-- > 0) {
			System.out.print("Enter N: ");
			int n = sc.nextInt();
			alphaHill(n);
			System.out.println();
		}
		sc.close();
	}

	public static void alphaHill(int n) {
		for (int i = 1; i <= n; i++) {
			// print spaces
			for (int j = 1; j <= n - i; j++) {
				System.out.print("  ");
			}
			// print alphabets
			char c = 'A' - 1;
			for (int j = 1; j <= 2 * i - 1; j++) {
				// Symmetric case
				if (j > i) {
					c--;
				} else {
					c++;
				}
				System.out.print(c + " ");
			}

			// print spaces
			for (int j = 1; j <= n - i; j++) {
				System.out.print("  ");
			}

			System.out.println();
		}
	}
	
	/**
	 * 	No of test cases: 2
		Enter N: 6
		          A           
		        A B A         
		      A B C B A       
		    A B C D C B A     
		  A B C D E D C B A   
		A B C D E F E D C B A 
		
		Enter N: 5
		        A         
		      A B A       
		    A B C B A     
		  A B C D C B A   
		A B C D E D C B A 
		

	 */
}
