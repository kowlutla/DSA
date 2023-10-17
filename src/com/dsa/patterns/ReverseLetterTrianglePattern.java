package com.dsa.patterns;

import java.util.Scanner;

public class ReverseLetterTrianglePattern {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("No of test cases: ");
		int t = sc.nextInt();

		while (t-- > 0) {
			System.out.print("Enter N: ");
			int n = sc.nextInt();
			nLetterTriangle(n);
			System.out.println();
		}
		sc.close();
	}

	public static void nLetterTriangle(int n) {
		// Write your code here
		for (int i = 1; i <= n; i++) {
			// for(int j=1;j<=n-i+1;j++){
			// System.out.print((char)('A'+j-1)+" ");
			// }

			for (char c = 'A'; c < 'A' + n - i + 1; c++) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 	No of test cases: 2
		Enter N: 5
		A B C D E 
		A B C D 
		A B C 
		A B 
		A 
		
		Enter N: 8
		A B C D E F G H 
		A B C D E F G 
		A B C D E F 
		A B C D E 
		A B C D 
		A B C 
		A B 
		A 

	 */
}
