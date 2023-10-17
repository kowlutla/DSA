package com.dsa.patterns;

import java.util.Scanner;

public class IncreasingLetterTrianglePattern {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("No of test cases: ");
		int t = sc.nextInt();

		while (t-- > 0) {
			System.out.print("Enter N: ");
			int n = sc.nextInt();
			// 1<=n<=26
			nLetterTriangle(n);
			System.out.println();
		}
		sc.close();
	}

	public static void nLetterTriangle(int n) {
		for (int i = 1; i <= n; i++) {
			// for(int j=1;j<=i;j++){
			// System.out.print((char)('A'+j-1)+" ");
			// }

			for (char c = 'A'; c < ('A' + i); c++) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 	No of test cases: 2
		Enter N: 5
		A 
		A B 
		A B C 
		A B C D 
		A B C D E 
		
		Enter N: 26
		A 
		A B 
		A B C 
		A B C D 
		A B C D E 
		A B C D E F 
		A B C D E F G 
		A B C D E F G H 
		A B C D E F G H I 
		A B C D E F G H I J 
		A B C D E F G H I J K 
		A B C D E F G H I J K L 
		A B C D E F G H I J K L M 
		A B C D E F G H I J K L M N 
		A B C D E F G H I J K L M N O 
		A B C D E F G H I J K L M N O P 
		A B C D E F G H I J K L M N O P Q 
		A B C D E F G H I J K L M N O P Q R 
		A B C D E F G H I J K L M N O P Q R S 
		A B C D E F G H I J K L M N O P Q R S T 
		A B C D E F G H I J K L M N O P Q R S T U 
		A B C D E F G H I J K L M N O P Q R S T U V 
		A B C D E F G H I J K L M N O P Q R S T U V W 
		A B C D E F G H I J K L M N O P Q R S T U V W X 
		A B C D E F G H I J K L M N O P Q R S T U V W X Y 
		A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 
		

	 */
}
